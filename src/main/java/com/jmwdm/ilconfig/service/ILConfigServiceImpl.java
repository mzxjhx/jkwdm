package com.jmwdm.ilconfig.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jmwdm.framework.Tools.JsonFormat;
import com.jmwdm.ilconfig.bean.ILConfig;
import com.jmwdm.ilconfig.dao.ILConfigDao;
/* 
 *     插损测试参数配置业务层
 * 2020年6月23日-下午4:11:21
 * 
 */
@Service
public class ILConfigServiceImpl implements IILService{

	Logger log = LoggerFactory.getLogger(ILConfigServiceImpl.class);
	
	@Autowired
	private ILConfigDao dao;
		
	@Override
	public String getConfig(ILConfig bean) {
		PageHelper.startPage(bean.getPageNum(), bean.getPageSize());
		List<ILConfig> list = dao.getList(bean);
		PageInfo<ILConfig> info = new PageInfo<ILConfig>(list);
		String msg = JsonFormat.formatList(200, "ok", info.getTotal(), info.getList()).toString();
		log.info(msg);
		return msg;
	}

	@Transactional
	public String saveConfig(ILConfig bean) {
		if(dao.insert(bean)>0)
			return JsonFormat.formatJsonBody(200, "保存成功").toString();
		return JsonFormat.formatJsonBody(100, "保存出错").toString();
	}

	@Transactional
	public String updateConfig(ILConfig bean) {
		// TODO Auto-generated method stub
		return "";
	}

	@Transactional
	public String deleteConfig(ILConfig bean) {
		if(dao.delete(bean)>0)
			return JsonFormat.formatJsonBody(200, "保存成功").toString();
		return JsonFormat.formatJsonBody(100, "保存出错").toString();
	}
	
	

}
