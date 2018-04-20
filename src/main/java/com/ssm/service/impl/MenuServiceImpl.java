package com.ssm.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ssm.dao.IMenuDao;
import com.ssm.dto.MenuReo;
import com.ssm.entity.Menu;
import com.ssm.entity.User;
import com.ssm.entity.UserMenu;
import com.ssm.service.IMenuService;
import com.ssm.service.IUserMenuService;

/**
 * 菜单模块业务实现类
 * @author ASUS
 *
 */
@Service("menuService")
public class MenuServiceImpl implements IMenuService{

	@Resource
	private IMenuDao dao;
	
	@Resource  
    private IUserMenuService userMenuService;
	
	@Resource
    private IMenuService menuService;
	
	/**
	 * 多条件查询
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> list(MenuReo dto) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		Page<Menu> page = PageHelper.startPage(dto.getPage(), dto.getLimit());
		List<Menu> list = dao.selectByMap(dto);
		
		map.put("code", 0);
		map.put("msg", "");
		map.put("data", list);
		map.put("count", page.getTotal());
		
		return map;
	}

	/**
	 * 查询所有
	 */
	public List<Menu> getAll() {
		return dao.selectAll();
	}
	
	/**
	 * 根据用户获取显示菜单
	 * @param user
	 * @return
	 */
	public List<Menu> getMenuByUser(User user) {
		List<Menu> menuList = new ArrayList<Menu>();
		List<UserMenu> list = userMenuService.getListByUserId(user.getId());
		
		if (list != null && list.size() > 0){
			for (UserMenu um:list){
				Menu mo = menuService.getById(um.getMenuId());
				if (mo != null){
					menuList.add(mo);
				}
			}
		}
		return menuList;
	}
	
	/**
	 * 根据id查询
	 */
	public Menu getById(Integer id) {
		return dao.selectByPrimaryKey(id);
	}
	
	/**
	 * 新增
	 */
	public int add(Menu eo) {
		return dao.insert(eo);
	}
	
	/**
	 * 修改
	 */
	public void edit(Menu eo) {
		dao.updateByPrimaryKey(eo);
	}
	
	/**
	 * 删除
	 */
	public void del(String ids) {
		String [] idArr = ids.split(",");
		for (String id:idArr){
			dao.deleteByPrimaryKey(Integer.valueOf(id));
		}
	}
}
