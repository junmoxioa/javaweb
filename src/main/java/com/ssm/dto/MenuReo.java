package com.ssm.dto;

/**
 * 接收菜单模块请求参数实体类
 * @author ASUS
 *
 */
public class MenuReo extends BaseReo{

	/**
	 * 菜单名称
	 */
	private String menuName;
	
	/**
	 * 菜单路径
	 */
	private String menuUrl;

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuUrl() {
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	
}
