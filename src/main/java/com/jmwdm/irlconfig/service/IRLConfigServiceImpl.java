package com.jmwdm.irlconfig.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jmwdm.framework.Tools.JsonFormat;
import com.jmwdm.irlconfig.bean.IRLConfig;
import com.jmwdm.irlconfig.dao.IRLDao;
/* 
 * 配置文件业务层
 * 2020年6月23日-下午4:11:21
 * 
 */
@Service
public class IRLConfigServiceImpl implements IRLService{

	Logger log = LoggerFactory.getLogger(IRLConfigServiceImpl.class);
	
	@Autowired
	private IRLDao dao;
		
	@Override
	public String getRLConfig(IRLConfig bean) {
		PageHelper.startPage(bean.getPageNum(), bean.getPageSize());
		List<IRLConfig> list = dao.getList(bean);
		PageInfo<IRLConfig> info = new PageInfo<IRLConfig>(list);
		String msg = JsonFormat.formatList(200, "ok", info.getTotal(), info.getList()).toString();
		log.info(msg);
		return msg;
	}

	@Override
	public String getILConfig(IRLConfig bean) {
		PageHelper.startPage(bean.getPageNum(), bean.getPageSize());
		List<IRLConfig> list = dao.getList(bean);
		PageInfo<IRLConfig> info = new PageInfo<IRLConfig>(list);
		String msg = JsonFormat.formatList(200, "ok", info.getTotal(), info.getList()).toString();
		log.info(msg);
		return msg;
	}

	@Transactional
	public String saveRLConfig(IRLConfig bean) {
		
		if(dao.saveRL(bean)>0)
			return JsonFormat.formatJsonBody(200, "保存成功").toString();
		return JsonFormat.formatJsonBody(100, "保存出错").toString();
	}

	@Transactional
	public String saveILConfig(IRLConfig bean) {
		if(dao.insert(bean)>0)
			return JsonFormat.formatJsonBody(200, "保存成功").toString();
		return JsonFormat.formatJsonBody(100, "保存出错").toString();
	}

	@Transactional
	public String updateRLConfig(IRLConfig bean) {
		// TODO Auto-generated method stub
		return "";
	}

	@Transactional
	public String updateILConfig(IRLConfig bean) {
		// TODO Auto-generated method stub
		return "";
	}

}
