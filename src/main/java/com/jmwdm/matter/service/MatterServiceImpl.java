package com.jmwdm.matter.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jmwdm.framework.Tools.JsonFormat;
import com.jmwdm.matter.bean.Matter;
import com.jmwdm.matter.dao.MatterDAO;
import com.jmwdm.matter.resource.MatterControl;
import com.jmwdm.trl.bean.Trl;

import net.sf.json.JSONObject;

/* 
 * HP
 * 2020年6月18日-下午3:51:15
 * 
 */
@Service
public class MatterServiceImpl implements IMatterService{

	private static final Logger log = LoggerFactory.getLogger(MatterControl.class);
	
	@Autowired
	MatterDAO dao;
	
	/**
	 * 
	 */
	public String getList(Matter bean) {
		PageHelper.startPage(bean.getPageNum(), bean.getPageSize());
		List<Matter> list = dao.getList(bean);
		PageInfo<Matter> info = new PageInfo<Matter>(list);
		String msg = JsonFormat.formatList(200, "ok", info.getTotal(), info.getList()).toString();
		log.info(msg);
		return msg;
	}

	@Transactional
	public int save(Matter bean) {
		// TODO Auto-generated method stub
		return dao.insert(bean);
	}

	@Transactional
	public int update(Matter bean) {
		// TODO Auto-generated method stub
		return dao.update(bean);
	}

	/**
	 * 
	 */
	public String getBean(Matter bean) {
		bean = dao.getBean(bean);
		String msg ="";
		if(bean != null)
			msg = JsonFormat.formatJsonBody(200, "ok", bean).toString();
		else
			msg = JsonFormat.formatJsonBody(100, "error", null).toString();
		log.info(msg);
		return msg;
	}

}
