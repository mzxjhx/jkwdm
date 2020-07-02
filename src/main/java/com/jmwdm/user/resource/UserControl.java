package com.jmwdm.user.resource;

import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jmwdm.framework.Tools.ExcelUtils;
import com.jmwdm.framework.Tools.ExportExcelUtils;
import com.jmwdm.framework.Tools.JsonFormat;
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
	
	/**
	 * 登录
	 * @param request
	 * @param response
	 * @param name
	 * @param passwd
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="login", method=RequestMethod.POST,  produces = "application/json;charset=UTF-8")
	public String login(HttpServletRequest request, 
			HttpServletResponse response,
			@RequestParam("name") String name, 
			@RequestParam("passwd") String passwd) {
		log.info("user/login");
		if(name == null || passwd == null) {
			return JsonFormat.formatList(100, "参数错误", 0, null).toString();
		}
		User bean = new User();
		bean.setLoginName(name);
		bean.setPasswd(passwd);
		bean = service.login(bean);
		if(bean!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", bean);
			log.info("{}登录系统",name);
			return JsonFormat.formatJsonBody(200, "ok", bean).toString();
		}
		return JsonFormat.formatJsonBody(100, "用户名或密码错误").toString();
		
		//return service.login(bean);		
	}
	
	/**
	 * 用户列表
	 * @param request
	 * @param response
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="getJson", method=RequestMethod.GET,  produces = "application/json;charset=UTF-8")
	public String getJson(HttpServletRequest request, 
			HttpServletResponse response,
			@RequestParam("pageNum") Integer pageNum, 
			@RequestParam("pageSize") Integer pageSize) {
		log.info("user/getJson");
		if(pageNum == null || pageSize == null) {
			return JsonFormat.formatList(100, "参数错误", 0, null).toString();
		}
		User bean = new User();
		bean.setPageNum(pageNum);
		bean.setPageSize(pageSize);
		return service.getJson(bean);
	}
	
	@ResponseBody
	@RequestMapping(value="loginOut", method=RequestMethod.POST,  produces = "application/json;charset=UTF-8")
	public String loginOut(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();		
		User user = (User)session.getAttribute("user");
		if(user != null)
		{
			log.info("{}退出系统",user.getLoginName());
		}
		session.invalidate();
		return JsonFormat.formatJsonBody(403, "退出系统").toString();
	}
	/**
	 * 
	 * @param request
	 * @param response

	@RequestMapping(value="exportExcel", method=RequestMethod.GET)
	public void exportExcel(HttpServletRequest request, HttpServletResponse response) {
		User bean = new User();
		List<User> list = service.getList(bean);
		//获取需要转出的excel表头的map字段
        LinkedHashMap<String, String> fieldMap = new LinkedHashMap<>();
        fieldMap.put("loginName","用户名");
        fieldMap.put("passwd","密码");
        fieldMap.put("role","权限");

		//ExcelUtils.export(response, list, new String[] {"id","用户名","密码","权限"});
        ExportExcelUtils.export("用户表",list,fieldMap,response);
	}
		 */
}
