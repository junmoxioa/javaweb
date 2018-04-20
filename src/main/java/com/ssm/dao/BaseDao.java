package com.ssm.dao;

/**
 * 数据层基本方法
 * @author ASUS
 * @param <T>
 *
 */
public interface BaseDao<T> {

	int deleteByPrimaryKey(Integer id);

    int insert(T record);

    int insertSelective(T record);

    T selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);
	
}
