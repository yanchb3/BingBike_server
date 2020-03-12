package bike.service;

public interface WeiXinInterface {
	// 请求的网址
    public static final String WX_LOGIN_URL = "https://api.weixin.qq.com/sns/jscode2session";
	// 你的appid
    public static final String WX_LOGIN_APPID = "wxaba4b5ba954c10b2";
	// 你的密匙
    public static final String WX_LOGIN_SECRET = "be464b94906a32f450fa50461812ca22";
	// 固定参数
    public static final String WX_LOGIN_GRANT_TYPE = "authorization_code";

}