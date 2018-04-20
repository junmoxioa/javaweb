package com.ssm.dao;

import java.util.List;

import com.ssm.entity.UserMenu;

public interface IUserMenuDao extends BaseDao<UserMenu>{
    
    /**
     * 根据用户ID查询对应的菜单ID
     * @param id
     * @return
     */
    List<UserMenu> selectByUserId(Integer userId);
    
    /**
     * 根据用户ID删除
     * @param id
     * @return
     */
    int deleteByUserId(Integer userId);
}