package com.jmwdm.ilconfig.resource;

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
import com.jmwdm.ilconfig.bean.ILConfig;
import com.jmwdm.ilconfig.service.IILService;

/* 
 * a 插损测试参数
 * 2020年6月23日-下午4:07:34
 * 
 */
@Controller
@RequestMapping(value="/config")
public class ILControl extends BaseControl{

	Logger log = LoggerFactory.getLogger(ILControl.class);
	
	@Autowired
	private IILService service;
	
	@ResponseBody
	@RequestMapping(value="/getList", method=RequestMethod.GET,  produces = "application/json;charset=UTF-8")
	public String getList(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("pageNum") Integer pageNum, 
			@RequestParam("pageSize") Integer pageSize) {
		
		if(pageNum == null || pageSize == null) {
			return JsonFormat.formatList(100, "参数错误", 0, null).toString();
		}
		ILConfig bean = new ILConfig();
		bean.setPageNum(pageNum);
		bean.setPageSize(pageSize);
		
		return service.getConfig(bean);
	}
	
	@ResponseBody
	@RequestMapping(value="/saveIL", method=RequestMethod.POST,  produces = "application/json;charset=UTF-8")
	public String saveIL(HttpServletRequest request,HttpServletResponse response,ILConfig bean) {
		
		return service.saveConfig(bean);				
	}
	
	@ResponseBody
	@RequestMapping(value="/deleteIL", method=RequestMethod.POST,  produces = "application/json;charset=UTF-8")
	public String deleteIL(HttpServletRequest request,HttpServletResponse response,ILConfig bean) {
		
		return service.deleteConfig(bean);				
	}
}
