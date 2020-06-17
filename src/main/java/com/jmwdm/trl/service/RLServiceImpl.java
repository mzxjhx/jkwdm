package com.jmwdm.trl.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jmwdm.framework.Tools.JsonFormat;
import com.jmwdm.trl.bean.Trl;
import com.jmwdm.trl.dao.RlDao;

import net.sf.json.JSONObject;

/* 
 * @author
 * 2020年6月8日-下午5:17:26
 */
@Service
public class RLServiceImpl implements IRLService{

	private static final Logger log = LoggerFactory.getLogger(RLServiceImpl.class);
	
	@Autowired 
	private RlDao dao;
	
	/**
	 * 
	 */
	public String getList(Trl bean) {
		JSONObject json= new JSONObject();
		json.put("data", dao.getList(bean));
		return json.toString();
	}

	/**
	 * 
	 */
	public String getJson(Trl bean) {
		PageHelper.startPage(bean.getPageNum(), bean.getPageSize());
		List<Trl> list = dao.getList(bean);
		PageInfo<Trl> info = new PageInfo<Trl>(list);
		String msg = JsonFormat.formatList(200, "ok", info.getTotal(), info.getList()).toString();
		log.info(msg);
		return msg;
	}

}
