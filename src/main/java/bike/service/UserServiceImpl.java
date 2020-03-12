package bike.service;


import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;

@Service("UserServiceImpl")
public class UserServiceImpl implements UserService{

	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	@Override
	public boolean sendMsg(String countryCode, String phoneNumber) {
		
		boolean flag=true;
		//step1.生成验证码
		//params[0]签名，params[1]验证码
		String[] params = {"BingBike","5678"};
		//step2.调用腾讯云API，向用户发送短信
		
		//2.1:parameters
		
		// 短信应用SDK AppID
		int appId = 1400279498; // 1400开头
		//String appId= stringRedisTemplate.opsForValue().get("appId");
		// 短信应用SDK AppKey
		String appKey = "7b392b4e98fd70abb442c003b96d9840";
		//String appKey=stringRedisTemplate.opsForValue().get("appKey") ;
		// 需要发送短信的手机号码
		//String[] phoneNumbers = {"21212313123", "12345678902", "12345678903"};
		// 短信模板ID，需要在短信应用中申请
		int templateId = 460928; // NOTE: 这里的模板ID`7839`只是一个示例，真实的模板ID需要在短信控制台中申请
		// 签名
		String smsSign = "BingBike"; // NOTE: 这里的签名"腾讯云"只是一个示例，真实的签名需要在短信控制台中申请
		
		
		//2.2:sendMsg
		SmsSingleSender ssender = new SmsSingleSender(appId, appKey);
	    try {
	    	//TODO:发送短信
			//SmsSingleSenderResult result = ssender.sendWithParam(countryCode, phoneNumber,templateId, params, smsSign, "", "");
			stringRedisTemplate.opsForValue().set(phoneNumber, params[1],180,TimeUnit.SECONDS);;
			//System.out.println(result);
		} catch (Exception e) {
			flag=false;
			e.printStackTrace();
		} 
	    
		//step3.将手机号作为key，验证码作为value，保存到redis中
		return flag;
	}

}
