package com.ssm.entity;

import java.util.List;

/**
 * 登录对象
 * 储存当前登录的用户信息及其他数据
 * @author ASUS
 *
 */
public class Login {

	/**
	 * 当前登录的用户
	 */
	private User user;
	
	/**
	 * 当前用户的菜单
	 */
	private List<Menu> menuList;

	public Login (){
		
	}
	
	public Login(User user, List<Menu> menuList){
		this.user = user;
		this.menuList = menuList;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Menu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}
	
}
