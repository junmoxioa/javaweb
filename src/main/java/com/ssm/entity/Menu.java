package com.ssm.entity;

public class Menu {
	
	/**
	 * 主键
	 */
    private Integer id;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 菜单路径
     */
    private String menuUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl == null ? null : menuUrl.trim();
    }
}