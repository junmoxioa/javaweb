package com.ssm.service;

/**
 * service基本方法
 * @author ASUS
 * @param <T>
 *
 */
public interface BaseService<T> {
	
	T getById(Integer id);
	
	int add(T eo);
	
	void edit(T eo);
	
	void del(String ids);
	
}
