package com.jmwdm.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.sf.json.JSONObject;

import com.jmwdm.user.bean.User;
import com.jmwdm.user.dao.UserDao;
/**
 * 
 * @author HP
 *
 */
@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private UserDao userDao;	
	
	public List<User> getList(User bean) {
		return userDao.getList(bean);
	}
	
	public String getJson(User bean) {
		// TODO Auto-generated method stub
		JSONObject json= new JSONObject();
		json.put("data", userDao.getList(bean));
		return json.toString();
	}

}
