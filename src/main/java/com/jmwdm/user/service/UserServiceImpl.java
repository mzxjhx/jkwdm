package com.jmwdm.user.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jmwdm.framework.Tools.JsonFormat;
import com.jmwdm.user.bean.User;
import com.jmwdm.user.dao.UserDao;
/**
 * 用户业务类
 * @author HP
 *
 */
@Service
public class UserServiceImpl implements IUserService{

	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
		
	@Autowired
	private UserDao userDao;	
	/**
	 * 登录，返回json
	 */
	public String login(User bean) {		
		bean = userDao.getBean(bean);
		if(bean==null)
			return JsonFormat.formatJsonBody(100, "用户名或密码错误", null).toString();
		return JsonFormat.formatJsonBody(200, "ok", bean).toString();
	}
	
	/**
	 * 
	 */
	public String getJson(User bean) {

		PageHelper.startPage(bean.getPageNum(), bean.getPageSize());
		List<User> list = userDao.getList(bean);
		PageInfo<User> info = new PageInfo<User>(list);
		String msg = JsonFormat.formatList(200, "ok", info.getTotal(), info.getList()).toString();
		log.info(msg);
		return msg;
	}

}
