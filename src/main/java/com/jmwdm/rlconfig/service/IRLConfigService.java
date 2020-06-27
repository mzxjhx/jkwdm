package com.jmwdm.rlconfig.service;

import com.jmwdm.rlconfig.bean.RLConfig;

/**
 *  ogt回损业务层接口
 *  CRUD操作
 * @author pc
 * @date 2020年6月26日
 */
public interface IRLConfigService {
	
	String getConfig(RLConfig bean);
	
	String saveConfig(RLConfig bean);

	String deleteConfig(RLConfig bean);
}
