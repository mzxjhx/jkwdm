package com.jmwdm.user.service;

import org.springframework.stereotype.Service;

import com.jmwdm.user.bean.User;

@Service
public interface IUserService {

	String getList(User bean);
}
