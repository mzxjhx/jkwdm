package com.jmwdm.user.resource;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jmwdm.user.bean.User;
import com.jmwdm.user.service.UserServiceImpl;
/*
 * 
 */
@Controller
@RequestMapping(value="/user")
public class UserControl {
	
	private static final Logger log = LoggerFactory.getLogger(UserControl.class);
	
	@Resource
	private UserServiceImpl service;
	
	@ResponseBody
	@RequestMapping(value="getList", method=RequestMethod.GET,  produces = "application/json;charset=UTF-8")
	public String getList(HttpServletRequest request, HttpServletResponse response) {
		log.info("user/getList");
		User bean = new User();
		return service.getList(bean);
	}
}
