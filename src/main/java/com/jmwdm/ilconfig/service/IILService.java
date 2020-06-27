package com.jmwdm.ilconfig.service;

import com.jmwdm.ilconfig.bean.ILConfig;
/**
 * a 插损测试参数业务接口
 * @author pc
 * @date 2020年6月26日
 */
public interface IILService{

	String getConfig(ILConfig bean);
	
	String saveConfig(ILConfig bean);
	
	String updateConfig(ILConfig bean);
	
	String deleteConfig(ILConfig bean);
}
