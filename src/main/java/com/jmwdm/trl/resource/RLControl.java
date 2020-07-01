package com.jmwdm.trl.resource;

import java.util.Enumeration;
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.jmwdm.framework.Tools.ExportExcelUtils;
import com.jmwdm.trl.bean.Trl;
import com.jmwdm.trl.service.RLServiceImpl;
import com.jmwdm.user.bean.User;

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
	public String getList(HttpServletRequest request, HttpServletResponse response,Trl bean) {
		log.info("rl/getList");
				
		return service.getList(bean);
	}
	
	/**
	 * 导出Excel
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="exportExcel", method=RequestMethod.GET)
	public void exportExcel(HttpServletRequest request, 
			HttpServletResponse response,Trl bean) {
		List<Trl> list = service.exportExcel(bean);
		//获取需要转出的excel表头的map字段
        LinkedHashMap<String, String> fieldMap = new LinkedHashMap<>();
        fieldMap.put("serialNumber","SN号");
        fieldMap.put("primitiveSn","原始sn");
        fieldMap.put("batchNumber","批次号");
        fieldMap.put("createTime","时间");
        fieldMap.put("staff","工号");
        fieldMap.put("level","等级");
        fieldMap.put("t1310","t1310");
        fieldMap.put("t1490","t1490");
        fieldMap.put("t1550","t1550");
        
        fieldMap.put("r1310","r1310");
        fieldMap.put("r1490","r1490");
        fieldMap.put("r1550","r1550");
        
        fieldMap.put("c1310","c1310");
        fieldMap.put("c1490","c1490");
        fieldMap.put("c1550","c1550");
        
        fieldMap.put("rlC","c端最小值");
        fieldMap.put("rlT","T端最小值");
        fieldMap.put("rlR","R端最小值");
		//ExcelUtils.export(response, list, new String[] {"id","用户名","密码","权限"});
        ExportExcelUtils.export("回损数据",list,fieldMap,response);
	}
}
