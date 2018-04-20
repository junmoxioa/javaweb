package com.ssm.dao;

import java.util.List;

import com.ssm.dto.UserReo;
import com.ssm.entity.User;

public interface IUserDao extends BaseDao<User>{
	
	/**
	 * 多条件查询
	 * @param dto
	 * @return
	 */
    List<User> selectByMap(UserReo dto);

    /**
     * 根据用户名查询
     * @param userName
     * @return
     */
	User selectByUserName(String userName);
}