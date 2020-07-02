package com.jmwdm.rlconfig.resource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jmwdm.framework.BaseControl;
import com.jmwdm.framework.Tools.JsonFormat;
import com.jmwdm.rlconfig.bean.RLConfig;
import com.jmwdm.rlconfig.service.IRLConfigService;
import com.jmwdm.user.bean.User;
/**
 * a回损测试参数配置
 * @author pc
 * @date 2020年6月26日
 */
@Controller
@RequestMapping(value="rlconfig")
public class RLConfigControl extends BaseControl{

	Logger log = LoggerFactory.getLogger(RLConfigControl.class);
	
	@Autowired
	private IRLConfigService service;
	
	@ResponseBody
	@RequestMapping(value="/getList", method=RequestMethod.GET,  produces = "application/json;charset=UTF-8")
	public String getList(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("pageNum") Integer pageNum, 
			@RequestParam("pageSize") Integer pageSize) {
		
		if(pageNum == null || pageSize == null) {
			return JsonFormat.formatList(100, "参数错误", 0, null).toString();
		}
		HttpSession session = request.getSession();		
		User user = (User)session.getAttribute("user");
		if(user == null) {
			return JsonFormat.formatJsonBody(401, "未登录").toString();
		}
		log.info("user={},url={}",user.getLoginName(),"/rlconfig/getList");
		if(user.getRole() == 2) {
			return JsonFormat.formatJsonBody(402, "没有该权限").toString();
		}
		
		RLConfig bean = new RLConfig();
		bean.setPageNum(pageNum);
		bean.setPageSize(pageSize);
		
		return service.getConfig(bean);
	}
	
	@ResponseBody
	@RequestMapping(value="/save", method=RequestMethod.POST,  produces = "application/json;charset=UTF-8")
	public String saveRL(HttpServletRequest request,HttpServletResponse response,RLConfig bean) {
		
		return service.saveConfig(bean);				
	}
	
	@ResponseBody
	@RequestMapping(value="/delete", method=RequestMethod.POST,  produces = "application/json;charset=UTF-8")
	public String delete(HttpServletRequest request,HttpServletResponse response,RLConfig bean) {
		
		return service.deleteConfig(bean);				
	}
}
