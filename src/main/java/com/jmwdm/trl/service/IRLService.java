package com.jmwdm.trl.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.jmwdm.trl.bean.Trl;

/* 
 * 回损业务层
 * 2020年6月8日-下午5:16:18
 */
@Service
public interface IRLService {

	String getList(Trl bean);
	
	List<Trl> exportExcel(Trl bean);
}
