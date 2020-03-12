package bike.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import bike.object.GlobalResult;
import bike.object.HttpClientUtil;
import bike.object.User;
import bike.mapper.UserMapper;
import bike.service.UserService;
import bike.service.WeiXinInterface;


@Controller
public class UserController {
	//@Autowired
	//private UserMapper userMapper;
	@Autowired
	private UserService userService;
	@RequestMapping("/user/getVerifyCode")
	@ResponseBody
	public boolean getVerifyCode(String countryCode,String phoneNumber) {
		boolean flag=userService.sendMsg(countryCode,phoneNumber);
		System.out.println(phoneNumber);
		return flag;
	}
	
	
	@RequestMapping("/user/wxLogin")
	@ResponseBody
//	public boolean user_login(
	
	public GlobalResult user_login(
	            @RequestParam("code") String code,
	            @RequestParam("userHead") String userHead,
	            @RequestParam("userName") String userName,
	            @RequestParam("userGender") String userGender,
	            @RequestParam("userCity") String userCity,
	            @RequestParam("userProvince") String userProvince){
		// 配置请求参数
		Map<String, String> param = new HashMap<>();
	    param.put("appid", WeiXinInterface.WX_LOGIN_APPID);
	    param.put("secret", WeiXinInterface.WX_LOGIN_SECRET);
	    param.put("js_code", code);
	    param.put("grant_type", WeiXinInterface.WX_LOGIN_GRANT_TYPE);
	    // 发送请求
		String wxResult = HttpClientUtil.doGet(WeiXinInterface.WX_LOGIN_URL, param);
		JSONObject jsonObject = JSON.parseObject(wxResult);
		// 获取参数返回的
		String session_key = jsonObject.get("session_key").toString();
		String open_id = jsonObject.get("openid").toString();
	    /*
        // 根据返回的user实体类，判断用户是否是新用户，不是的话，更新最新登录时间，是的话，将用户信息存到数据库
        User user = userMapper.selectById(open_id);
        if(user != null){
        	user.setLastVisitTime(new Date());
        	userMapper.updateById(user);
	    }else{
    	    User insert_user = new User();
	   	 	insert_user.setAvatarUrl(userHead);
	        insert_user.setNickName(userName);
	        insert_user.setGender(userGender);
	        insert_user.setLastVisitTime(new Date());
	        insert_user.setCity(userCity);
	        insert_user.setProvince(userProvince);
	        insert_user.setOpenId(open_id);
	        System.out.println("insert_user:"+insert_user.toString());
	        // 添加到数据
	        userMapper.insert(insert_user);
	    }
	    */
	    // 封装返回小程序
	    Map<String, String> result = new HashMap<>();
	    result.put("session_key", session_key);
	    result.put("open_id", open_id);
	    return new GlobalResult(result);
        //return true;
	}

}
