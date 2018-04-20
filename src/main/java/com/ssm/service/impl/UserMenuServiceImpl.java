package com.ssm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.dao.IUserMenuDao;
import com.ssm.entity.UserMenu;
import com.ssm.service.IUserMenuService;

/**
 * 用户菜单业务实现类
 * @author ASUS
 *
 */
@Service("userMenuService")
public class UserMenuServiceImpl implements IUserMenuService {

	@Resource
	IUserMenuDao dao;
	
	/**
	 * 多添件查询
	 */
	public List<UserMenu> getListByUserId(int userId) {
		return dao.selectByUserId(userId);
	}

	/**
	 * 根据用户ID删除
	 */
	public void delByUserId(int userId) {
		dao.deleteByUserId(userId);
	}

	/**
	 * 下方增删改查
	 */
	public UserMenu getById(Integer id) {
		return dao.selectByPrimaryKey(id);
	}

	public int add(UserMenu eo) {
		return dao.insert(eo);
	}

	public void edit(UserMenu eo) {
		dao.updateByPrimaryKey(eo);
	}

	public void del(String ids) {
		String [] idArr = ids.split(",");
		for (String id:idArr){
			dao.deleteByPrimaryKey(Integer.valueOf(id));
		}
	}

}
