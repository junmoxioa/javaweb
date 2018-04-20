package com.ssm.entity;

public class UserMenu {
	
	/**
	 * 主键
	 */
    private Integer id;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 菜单ID
     */
    private Integer menuId;
    
    /**
     * 是否显示
     * 0：显示, 1：不显示
     */
    private Integer isShow = 0;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

	public Integer getIsShow() {
		return isShow;
	}

	public void setIsShow(Integer isShow) {
		this.isShow = isShow;
	}
}