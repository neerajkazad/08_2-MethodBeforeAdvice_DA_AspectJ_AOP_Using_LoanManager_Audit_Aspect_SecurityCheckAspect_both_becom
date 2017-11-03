package com.mba.helper;

import com.mba.bean.UserInfo;

public class AuthenticationHelper {
	private static AuthenticationHelper instance;
	private ThreadLocal<UserInfo> threadLocal;
	
	private AuthenticationHelper() {
		threadLocal = new ThreadLocal<UserInfo>();
	}
	
	public synchronized static AuthenticationHelper getInstance() {
		if(instance == null) {
			instance = new AuthenticationHelper();
		}
		return instance;
	}
	
	public void login(String un, String pwd) {
		/*UserInfo userInfo = null;
		userInfo = new UserInfo(un, pwd);
		threadLocal.set(userInfo);*/
		threadLocal.set(new UserInfo(un, pwd)); //one liner same as above code
		
		 
	}
	
	public void logout() {
		threadLocal.set(null);
	}
	
	public boolean authenticate() {
		UserInfo ui = null;
		ui = threadLocal.get();
		if(ui != null) {
			if(ui.getUn().equals("john") && ui.getPwd().equals("welcome1")) {
				return true;
			}
		}
		return false;
	}
	
	public String getLoggedInUser() {
		UserInfo ui = null;
		ui = threadLocal.get();
		if(ui != null) {
			return ui.getUn();
		}
		return null;
	}
}
