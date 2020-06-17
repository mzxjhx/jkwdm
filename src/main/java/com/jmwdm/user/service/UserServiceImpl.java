package com.jmwdm.user.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
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
    private StringRedisTemplate stringRedisTemplate;
    
	@Autowired
    private RedisTemplate redisTemplate;
	
	@Autowired
	private UserDao userDao;	
	/**
	 * 
	 */
	public List<User> getList(User bean) {
		return userDao.getList(bean);
	}
	
	/**
	 * 
	 */
	public String getJson(User bean) {
		//stringRedisTemplate.opsForValue().set("aaa", "111");
		PageHelper.startPage(bean.getPageNum(), bean.getPageSize());
		List<User> list = userDao.getList(bean);
		PageInfo<User> info = new PageInfo<User>(list);
		String msg = JsonFormat.formatList(200, "ok", info.getTotal(), info.getList()).toString();
		log.info(msg);
		return msg;
	}

}
