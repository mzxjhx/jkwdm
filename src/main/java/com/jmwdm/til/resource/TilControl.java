package com.jmwdm.til.resource;

import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jmwdm.framework.BaseControl;
import com.jmwdm.framework.Tools.ExportExcelUtils;
import com.jmwdm.framework.Tools.JsonFormat;
import com.jmwdm.til.bean.Til;
import com.jmwdm.til.service.ITilService;
import com.jmwdm.trl.bean.Trl;
import com.jmwdm.user.bean.User;

/* 
 * HP
 * 2020年6月28日-下午4:54:25
 * 
 */
@Controller
@RequestMapping(value="il")
public class TilControl extends BaseControl{
	
	Logger log = LoggerFactory.getLogger(TilControl.class);	
	
	@Autowired
	private ITilService service;
	
	@ResponseBody
	@RequestMapping(value="/getList", method=RequestMethod.GET,  produces = "application/json;charset=UTF-8")
	public String getList(HttpServletRequest request, HttpServletResponse response,Til bean) {
		
		return service.getList(bean);
	}
	
	/**
	 * 导出Excel
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="exportExcel", method=RequestMethod.GET)
	public void exportExcel(HttpServletRequest request, HttpServletResponse response,Til bean) {
			
		List<Til> list = service.exportExcel(bean);
		//获取需要转出的excel表头的map字段
        LinkedHashMap<String, String> fieldMap = new LinkedHashMap<>();
        fieldMap.put("serialNumber","SN号");
        fieldMap.put("primitiveSn","原始sn");
        fieldMap.put("batchNumber","批次号");
        fieldMap.put("table","工位");
        fieldMap.put("createTime","时间");
        fieldMap.put("staff","工号");
        fieldMap.put("type","类型");
        fieldMap.put("wave1","透射波长");
        fieldMap.put("il1","透射值");
        fieldMap.put("wave2","反射波长");
        fieldMap.put("il2","反射值");
        fieldMap.put("ref1","参考值1");
        fieldMap.put("ref2","参考值2");
        fieldMap.put("config","配置文件");

        ExportExcelUtils.export("回损数据",list,fieldMap,response);
	}
}
