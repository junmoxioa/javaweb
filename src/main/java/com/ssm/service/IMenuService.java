package com.ssm.service;

import java.util.List;
import java.util.Map;

import com.ssm.dto.MenuReo;
import com.ssm.entity.Menu;
import com.ssm.entity.User;

public interface IMenuService extends BaseService<Menu>{

	/**
	 * 查询所有
	 * @return
	 */
	List<Menu> getAll();
	
	/**
	 * 多条件查询
	 * @param dto
	 * @return
	 */
	Map<String, Object> list(MenuReo dto);
	
	/**
	 * 查询用户的菜单
	 */
	List<Menu> getMenuByUser(User user);
}
