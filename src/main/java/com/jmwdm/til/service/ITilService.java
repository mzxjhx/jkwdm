package com.jmwdm.til.service;

import java.util.List;

import com.jmwdm.til.bean.Til;

/* 
 * 插损业务层
 * 2020年6月28日-下午4:53:22
 * 
 */
public interface ITilService {

	String getList(Til bean);
	
	List<Til> exportExcel(Til bean);
}
