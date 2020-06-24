package com.jmwdm.irlconfig.service;
/* 
 * HP
 * 2020年6月23日-下午4:09:16
 * 
 */

import java.util.List;

import com.jmwdm.irlconfig.bean.IRLConfig;

public interface IRLService{

	String getRLConfig(IRLConfig bean);

	String getILConfig(IRLConfig bean);
	
	String saveRLConfig(IRLConfig bean);
	
	String saveILConfig(IRLConfig bean);
	
	String updateRLConfig(IRLConfig bean);
	
	String updateILConfig(IRLConfig bean);
}
