package com.ssm.service;

import java.util.List;

import com.ssm.entity.UserMenu;

public interface IUserMenuService extends BaseService<UserMenu>{

	/**
	 * 根据用户ID查询
	 * @param userId
	 * @return
	 */
	List<UserMenu> getListByUserId(int userId);
	
	/**
	 * 根据用户ID删除
	 * @param userId
	 */
	void delByUserId(int userId);

}
