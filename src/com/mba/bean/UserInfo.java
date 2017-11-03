package com.mba.bean;

public class UserInfo {
	private String un;
	private String pwd;

	public UserInfo(String un, String pwd) {
		this.un = un;
		this.pwd = pwd;
	}

	public String getUn() {
		return un;
	}

	public void setUn(String un) {
		this.un = un;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}
