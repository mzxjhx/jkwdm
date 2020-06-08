package com.jmwdm.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.jmwdm.user.bean.User;

@Repository
public interface UserDao {
	
	public List<User> getList(User bean);
	
	public User getBean(User bean);
}
