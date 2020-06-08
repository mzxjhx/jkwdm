package com.jmwdm.framework;

import java.util.List;

/**
 * 
 * @author pc
 * @date 2020年6月7日
 * @param <T>
 */
public interface BaseDao<T> {

	public int insert(T bean);
	
	public int update(T bean);
	
	public int delete(T bean);
	
	public List<T> getList(T bean);
	
	public T getBean(T bean);
}
