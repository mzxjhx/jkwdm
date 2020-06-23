package com.jmwdm.user.bean;

import com.jmwdm.framework.BaseBean;
/**
 * 用户表
 * @author pc
 * @date 2020年6月7日
 */
public class User extends BaseBean{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	int id;
	String userKey;
	String loginName;	
	String passwd;	
	int role;
	String loginTime;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserKey() {
		return userKey;
	}
	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public String getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}
	

	
}
