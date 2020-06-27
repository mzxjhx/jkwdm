package com.jmwdm.trl.resource;

import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jmwdm.framework.Tools.ExportExcelUtils;
import com.jmwdm.framework.Tools.JsonFormat;
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
	public String getList(HttpServletRequest request, 
			HttpServletResponse response,
			@RequestParam("pageNum") Integer pageNum, 
			@RequestParam("pageSize") Integer pageSize) {
		log.info("rl/getList");
		if(pageNum == null || pageSize == null) {
			return JsonFormat.formatList(100, "参数错误", 0, null).toString();
		}
		Trl bean = new Trl();
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
		Trl bean = new Trl();
		List<Trl> list = service.exportExcel(bean);
		//获取需要转出的excel表头的map字段
        LinkedHashMap<String, String> fieldMap = new LinkedHashMap<>();
        fieldMap.put("serialNumber","SN号");
        fieldMap.put("primitiveSn","原始sn");
        fieldMap.put("batchNumber","批次号");

		//ExcelUtils.export(response, list, new String[] {"id","用户名","密码","权限"});
        ExportExcelUtils.export("回损数据",list,fieldMap,response);
	}
}
