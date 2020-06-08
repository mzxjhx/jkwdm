package com.jmwdm.trl.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jmwdm.trl.bean.Trl;

/**
 * 
 * @author HP
 * 
 */
@Repository
public interface RlDao {
	
	public List<Trl> getList(Trl bean);
}
