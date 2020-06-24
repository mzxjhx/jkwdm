package com.jmwdm.irlconfig.resource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.jmwdm.irlconfig.bean.IRLConfig;
import com.jmwdm.irlconfig.service.IRLService;

/* 
 * HP
 * 2020年6月23日-下午4:07:34
 * 
 */
@Controller
@RequestMapping(value="/config")
public class IRLControl extends BaseControl{

	Logger log = LoggerFactory.getLogger(IRLControl.class);
	
	@Autowired
	private IRLService service;
	
	@ResponseBody
	@RequestMapping(value="/getList", method=RequestMethod.GET,  produces = "application/json;charset=UTF-8")
	public String getList(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("pageNum") Integer pageNum, 
			@RequestParam("pageSize") Integer pageSize) {
		
		if(pageNum == null || pageSize == null) {
			return JsonFormat.formatList(100, "参数错误", 0, null).toString();
		}
		IRLConfig bean = new IRLConfig();
		bean.setPageNum(pageNum);
		bean.setPageSize(pageSize);
		
		return service.getRLConfig(bean);
	}
	
	@ResponseBody
	@RequestMapping(value="/saveRL", method=RequestMethod.POST,  produces = "application/json;charset=UTF-8")
	public String saveRL(HttpServletRequest request,HttpServletResponse response,IRLConfig bean) {
		
		return service.saveRLConfig(bean);
				
	}
}
