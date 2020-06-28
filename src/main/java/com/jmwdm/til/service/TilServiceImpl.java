package com.jmwdm.til.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jmwdm.framework.Tools.JsonFormat;
import com.jmwdm.rlconfig.bean.RLConfig;
import com.jmwdm.rlconfig.service.RLConfigServiceImpl;
import com.jmwdm.til.bean.Til;
import com.jmwdm.til.dao.TilDao;
import com.jmwdm.trl.bean.Trl;

/* 
 * 获取插损数据
 * 2020年6月28日-下午4:55:19
 * 
 */
@Service
public class TilServiceImpl implements ITilService{

	private static Logger log = LoggerFactory.getLogger(TilServiceImpl.class);
	
	@Autowired
	private TilDao dao;
	
	@Override
	public String getList(Til bean) {
		PageHelper.startPage(bean.getPageNum(), bean.getPageSize());
		List<Til> list = dao.getList(bean);
		PageInfo<Til> info = new PageInfo<Til>(list);
		String msg = JsonFormat.formatList(200, "ok", info.getTotal(), info.getList()).toString();
		log.info(msg);
		return msg;
	}

	/**
	 * 导出Excel
	 */
	public List<Til> exportExcel(Til bean) {
		List<Til> list = dao.getList(bean);
		PageInfo<Til> info = new PageInfo<Til>(list);
		return info.getList();
	}

}
