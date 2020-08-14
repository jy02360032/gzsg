/**
 * 
 */
package net.webset.config;

/**
 * @author 梁雪峰
 *
 */
public class BrowserProperties {
	
	private SessionProperties session = new SessionProperties();
	
	private String[] staticSources = {"/static/**"};
		
	private String loginPage = SecurityConstants.DEFAULT_LOGIN_PAGE_URL;
	
	private String loginFordPath = SecurityConstants.DEFAULT_LOGIN_FORD_PATH_URL;
	
	private LoginResponseType loginType = LoginResponseType.JSON;
	
	private int rememberMeSeconds = 3600 * 24 * 7;
	
	private String logOutPage = "/logout.html";
	
	private String loginProcess = SecurityConstants.DEFAULT_UNAUTHENTICATION_URL;
	
	private String loginFordPage = SecurityConstants.DEFAULT_LOGIN_FORD_PATH_PAGE;
	
	private String loginFordProcess = SecurityConstants.DEFAULT_LOGIN_FORD_PROCESS;

	public String getLoginPage() {
		return loginPage;
	}

	public void setLoginPage(String loginPage) {
		this.loginPage = loginPage;
	}

	public LoginResponseType getLoginType() {
		return loginType;
	}

	public void setLoginType(LoginResponseType loginType) {
		this.loginType = loginType;
	}

	public int getRememberMeSeconds() {
		return rememberMeSeconds;
	}

	public void setRememberMeSeconds(int rememberMeSeconds) {
		this.rememberMeSeconds = rememberMeSeconds;
	}
	
	public String[] getStaticSources() {
		return staticSources;
	}

	public void setStaticSources(String[] staticSources) {
		this.staticSources = staticSources;
	}

	public SessionProperties getSession() {
		return session;
	}

	public void setSession(SessionProperties session) {
		this.session = session;
	}

	public String getLogOutPage() {
		return logOutPage;
	}

	public void setLogOutPage(String logOutPage) {
		this.logOutPage = logOutPage;
	}

	public String getLoginProcess() {
		return loginProcess;
	}

	public void setLoginProcess(String loginProcess) {
		this.loginProcess = loginProcess;
	}

	public String getLoginFordPath() {
		return loginFordPath;
	}

	public void setLoginFordPath(String loginFordPath) {
		this.loginFordPath = loginFordPath;
	}

	public String getLoginFordPage() {
		return loginFordPage;
	}

	public void setLoginFordPage(String loginFordPage) {
		this.loginFordPage = loginFordPage;
	}

	public String getLoginFordProcess() {
		return loginFordProcess;
	}

	public void setLoginFordProcess(String loginFordProcess) {
		this.loginFordProcess = loginFordProcess;
	}
	
}
