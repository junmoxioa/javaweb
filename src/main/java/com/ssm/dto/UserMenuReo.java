package com.ssm.dto;

import java.util.List;

/**
 * 接受用户菜单模块参数实体类
 * @author ASUS
 *
 */
public class UserMenuReo extends BaseReo {

	/**
	 * 用户ID
	 */
	private int userId;
	
	/**
	 * 菜单ID
	 */
	private List<Integer> menuIds;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public List<Integer> getMenuIds() {
		return menuIds;
	}

	public void setMenuIds(List<Integer> menuIds) {
		this.menuIds = menuIds;
	}
}
