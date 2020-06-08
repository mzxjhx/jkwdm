package com.jmwdm.trl.resource;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jmwdm.trl.bean.Trl;
import com.jmwdm.trl.service.RLServiceImpl;

/* 
 * @author
 * 2020年6月8日-下午5:20:05
 */
@Controller
@RequestMapping(value="/rl")
public class RLControl {

private static final Logger log = LoggerFactory.getLogger(RLControl.class);
	
	@Resource
	private RLServiceImpl service;
	
	@ResponseBody
	@RequestMapping(value="/getList", method=RequestMethod.GET,  produces = "application/json;charset=UTF-8")
	public String getList(HttpServletRequest request, HttpServletResponse response) {
		log.info("rl/getList");
		Trl bean = new Trl();
		return service.getList(bean);
	}
}
