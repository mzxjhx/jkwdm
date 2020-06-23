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
	public int saveRLConfig(IRLConfig bean) {
		// TODO Auto-generated method stub
		return dao.insert(bean);
	}

	@Transactional
	public int saveILConfig(IRLConfig bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Transactional
	public int updateRLConfig(IRLConfig bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Transactional
	public int updateILConfig(IRLConfig bean) {
		// TODO Auto-generated method stub
		return 0;
	}

}
