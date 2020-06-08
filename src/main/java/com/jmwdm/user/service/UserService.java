package com.jmwdm.user.service;

import org.springframework.stereotype.Service;

import com.jmwdm.user.bean.User;

@Service
public interface UserService {

	String getList(User bean);
}
