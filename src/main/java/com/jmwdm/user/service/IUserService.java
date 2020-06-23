package com.jmwdm.user.service;


import org.springframework.stereotype.Service;
import com.jmwdm.user.bean.User;

@Service
public interface IUserService {
	/**
	 * 登录
	 * @param bean
	 * @return
	 */
	String login(User bean);
	/**
	 * 员工列表
	 * @param bean
	 * @return
	 */
	String getJson(User bean);
}
