package com.jmwdm.til.resource;

import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jmwdm.framework.BaseControl;
import com.jmwdm.framework.Tools.ExportExcelUtils;
import com.jmwdm.framework.Tools.JsonFormat;
import com.jmwdm.til.bean.Til;
import com.jmwdm.til.service.ITilService;
import com.jmwdm.trl.bean.Trl;

/* 
 * HP
 * 2020年6月28日-下午4:54:25
 * 
 */
@Controller
@RequestMapping(value="il")
public class TilControl extends BaseControl{
	
	
	@Autowired
	private ITilService service;
	
	@ResponseBody
	@RequestMapping(value="/getList", method=RequestMethod.GET,  produces = "application/json;charset=UTF-8")
	public String getList(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("pageNum") Integer pageNum, 
			@RequestParam("pageSize") Integer pageSize) {
		
		if(pageNum == null || pageSize == null) {
			return JsonFormat.formatList(100, "参数错误", 0, null).toString();
		}
		Til bean = new Til();
		bean.setPageNum(pageNum);
		bean.setPageSize(pageSize);
		
		return service.getList(bean);
	}
	
	/**
	 * 导出Excel
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="exportExcel", method=RequestMethod.GET)
	public void exportExcel(HttpServletRequest request, 
			HttpServletResponse response) {
		Til bean = new Til();
		List<Til> list = service.exportExcel(bean);
		//获取需要转出的excel表头的map字段
        LinkedHashMap<String, String> fieldMap = new LinkedHashMap<>();
        fieldMap.put("serialNumber","SN号");
        fieldMap.put("primitiveSn","原始sn");
        fieldMap.put("batchNumber","批次号");

		//ExcelUtils.export(response, list, new String[] {"id","用户名","密码","权限"});
        ExportExcelUtils.export("回损数据",list,fieldMap,response);
	}
}
