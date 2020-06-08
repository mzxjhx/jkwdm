package com.jmwdm.trl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmwdm.trl.bean.Trl;
import com.jmwdm.trl.dao.RlDao;

import net.sf.json.JSONObject;

/* 
 * @author
 * 2020年6月8日-下午5:17:26
 */
@Service
public class RLServiceImpl implements IRLService{

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

}
