package com.jmwdm.matter.resource;

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

import com.jmwdm.framework.Tools.JsonFormat;
import com.jmwdm.matter.bean.Matter;
import com.jmwdm.matter.service.IMatterService;


/* 
 * HP
 * 2020年6月18日-下午4:03:09
 * 
 */
@Controller
@RequestMapping("/matter")
public class MatterControl {

	private static final Logger log = LoggerFactory.getLogger(MatterControl.class);
	
	@Autowired
	private IMatterService service;
	
	@ResponseBody
	@RequestMapping(value="/getList", method=RequestMethod.GET,  produces = "application/json;charset=UTF-8")
	public String getList(HttpServletRequest request, 
			HttpServletResponse response,
			@RequestParam("pageNum") Integer pageNum, 
			@RequestParam("pageSize") Integer pageSize) {
		
		if(pageNum == null || pageSize == null) {
			return JsonFormat.formatList(100, "参数错误", 0, null).toString();
		}
		Matter bean = new Matter();
		bean.setPageNum(pageNum);
		bean.setPageSize(pageSize);
		return service.getList(bean);

	}
}
