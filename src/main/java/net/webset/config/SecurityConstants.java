/**
 * 
 */
package net.webset.config;

/**
 * @author 梁雪峰
 *
 */
public interface SecurityConstants {
	
	/**
	 * 默认的处理验证码的url前缀
	 */
	public static final String DEFAULT_VALIDATE_CODE_URL_PREFIX = "/code";
	/**
	 * 当请求需要身份认证时，默认跳转的url
	 * 
	 * @see SecurityController
	 */
	public static final String DEFAULT_UNAUTHENTICATION_URL = "/admin/index.html";
	/**
	 * 默认的用户名密码登录请求处理url
	 */
	public static final String DEFAULT_LOGIN_PROCESSING_URL_FORM = "/admin/index.html";
	/**
	 * 默认的手机验证码登录请求处理url
	 */
	public static final String DEFAULT_LOGIN_PROCESSING_URL_MOBILE = "/mobile.html";
	/**
	 * 默认登录页面
	 * 
	 * @see SecurityController
	 */
	public static final String DEFAULT_LOGIN_PAGE_URL = "/admin/login.html";
	/**
	 * 验证图片验证码时，http请求中默认的携带图片验证码信息的参数的名称
	 */
	public static final String DEFAULT_PARAMETER_NAME_CODE_IMAGE = "imageCode";
	/**
	 * 验证短信验证码时，http请求中默认的携带短信验证码信息的参数的名称
	 */
	public static final String DEFAULT_PARAMETER_NAME_CODE_SMS = "smsCode";
	/**
	 * 发送短信验证码 或 验证短信验证码时，传递手机号的参数的名称
	 */
	public static final String DEFAULT_PARAMETER_NAME_MOBILE = "mobile";
	/**
	 * session失效默认的跳转地址
	 */
	public static final String DEFAULT_SESSION_INVALID_URL = "/admin/login.html";
	/**
	 * 前台拦截URL
	 */
	public static final String DEFAULT_LOGIN_FORD_PATH_URL = "/ford/**";
	/**
	 * 前台登录地址
	 */
	public static final String DEFAULT_LOGIN_FORD_PATH_PAGE = "/admin/fordLogin.html";
	/**
	 * 前台登录方法
	 */
	public static final String DEFAULT_LOGIN_FORD_PROCESS = "/admin/fordindex.html";
	/**
	 * 前台session失败地址
	 */
	public static final String DEFAULT_SESSION_FORD_INVALID_URL = "/admin/fordindex.html";
	
	/**
	 * 权限节点
	 */
	public static final String AUTH_NODE = "authNode";

}
