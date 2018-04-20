package com.ssm.service;

import java.util.List;
import java.util.Map;

import com.ssm.dto.UserReo;
import com.ssm.entity.User;

public interface IUserService extends BaseService<User>{

	/**
	 * 新增用户
	 * @param dto
	 * @return
	 */
	int add(UserReo dto);
	
	/**
	 * 多条件查询
	 * @param dto
	 * @return
	 */
	Map<String, Object> list(UserReo dto);

	/**
	 * 配置用户菜单权限
	 * @param userId
	 * @param menuIds
	 */
	void root_config(int userId, List<Integer> menuIds);

	/**
	 * 检查用户名是否已存在
	 * @param userName
	 */
	void check_username(String userName);

	/**
	 * 用户登录
	 * @param userName
	 * @param password
	 * @param request
	 */
	User login(String userName, String password);

	/**
	 * 修改用户
	 * @param dto
	 * @param user 
	 */
	void edit(UserReo dto, User user);
}
