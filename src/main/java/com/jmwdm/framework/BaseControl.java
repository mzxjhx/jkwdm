package com.jmwdm.framework;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.jmwdm.user.bean.User;

/* 
 * HP
 * 2020年6月10日-下午1:52:07
 * 
 */
public class BaseControl {

	public boolean checkRole(HttpServletRequest request) {
		
		HttpSession session = request.getSession();		
		User user = (User)session.getAttribute("user");
		if(user == null) {
			return false;
		}
		if(user.getRole() == 2) {
			return false;
		}
		return true;
	}
}
