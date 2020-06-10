package com.jmwdm.trl.service;


import org.springframework.stereotype.Service;

import com.jmwdm.trl.bean.Trl;

/* 
 * 回损业务层
 * 2020年6月8日-下午5:16:18
 */
@Service
public interface IRLService {

	String getList(Trl bean);
	
	String getJson(Trl bean);
}
