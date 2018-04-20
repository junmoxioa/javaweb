package com.ssm.dao;

import java.util.List;

import com.ssm.dto.MenuReo;
import com.ssm.entity.Menu;

public interface IMenuDao extends BaseDao<Menu>{
	
	/**
	 * 多条件查询
	 * @param mreo
	 * @return
	 */
    List<Menu> selectByMap(MenuReo mreo);

    /**
     * 查询所有
     * @return
     */
	List<Menu> selectAll();
}