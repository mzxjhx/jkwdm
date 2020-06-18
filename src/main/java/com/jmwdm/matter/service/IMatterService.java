package com.jmwdm.matter.service;

import com.jmwdm.matter.bean.Matter;

/* 
 * HP
 * 2020年6月18日-下午3:50:19
 * 
 */
public interface IMatterService {

	String getList(Matter bean);
	
	int save(Matter bean);
	
	int update(Matter bean);
	
	String getBean(Matter bean);
}
