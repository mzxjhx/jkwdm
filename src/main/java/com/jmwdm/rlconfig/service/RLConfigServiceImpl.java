package com.jmwdm.rlconfig.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jmwdm.framework.Tools.JsonFormat;
import com.jmwdm.rlconfig.bean.RLConfig;
import com.jmwdm.rlconfig.dao.RLConfigDao;
/**
 * a 回损业务层
 * @author pc
 * @date 2020年6月26日
 */
@Service
public class RLConfigServiceImpl implements IRLConfigService{
	
	private static Logger log = LoggerFactory.getLogger(RLConfigServiceImpl.class);

	@Autowired
	private RLConfigDao dao;
	
	@Override
	public String getConfig(RLConfig bean) {
		
		PageHelper.startPage(bean.getPageNum(), bean.getPageSize());
		List<RLConfig> list = dao.getList(bean);
		PageInfo<RLConfig> info = new PageInfo<RLConfig>(list);
		String msg = JsonFormat.formatList(200, "ok", info.getTotal(), info.getList()).toString();
		//log.info(msg);
		return msg;
	}

	@Transactional
	public String saveConfig(RLConfig bean) {
		if(dao.insert(bean) > 0)
			return JsonFormat.formatJsonBody(200, "保存成功").toString();
		return JsonFormat.formatJsonBody(100, "保存出错").toString();
	}

	@Transactional
	public String deleteConfig(RLConfig bean) {
		if(dao.delete(bean) > 0)
			return JsonFormat.formatJsonBody(200, "删除成功").toString();
		return JsonFormat.formatJsonBody(100, "系统出错，请重试").toString();
	}

}
