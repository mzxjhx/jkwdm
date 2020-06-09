package com.jmwdm.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jmwdm.user.bean.User;

@Service
public interface IUserService {

	List<User> getList(User bean);
	
	String getJson(User bean);
}
