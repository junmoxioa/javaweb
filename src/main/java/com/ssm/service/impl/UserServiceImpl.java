package com.ssm.service.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ssm.dao.IUserDao;
import com.ssm.dto.UserReo;
import com.ssm.entity.User;
import com.ssm.entity.UserMenu;
import com.ssm.exception.UserException;
import com.ssm.service.IMenuService;
import com.ssm.service.IUserMenuService;
import com.ssm.service.IUserService;
import com.ssm.util.MD5Util;

/**
 * 用户业务实现类
 * @author ASUS
 *
 */
@Service("userService")
public class UserServiceImpl implements IUserService {
	
    @Resource
    private IUserDao dao;
    
    @Resource
    private IUserMenuService userMenuService;
    
    @Resource
    private IMenuService menuService;
    
    /**
     * 新增用户
     */
	public int add(UserReo dto) {
		
		check_username(dto.getUserName());
		
		if (!dto.getPassword().equals(dto.getPassword2())){
			throw new UserException("两次密码不一致");
		}
		
		User eo = new User();
		eo.setUserName(dto.getUserName());
		eo.setPassword(MD5Util.getMD5(dto.getPassword()));
		eo.setAge(dto.getAge());
		
		return dao.insert(eo);
	}

	/**
	 * 条件查询
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> list(UserReo dto) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		Page<User> page = PageHelper.startPage(dto.getPage(), dto.getLimit());
		List<User> list = dao.selectByMap(dto);
		
		map.put("code", 0);
		map.put("msg", "");
		map.put("data", list);
		map.put("count", page.getTotal());
		
		return map;
	}

	/**
	 * 配置用户菜单权限
	 */
	public void root_config(int userId, List<Integer> menuIds) {
		try{
			userMenuService.delByUserId(userId);
			if (menuIds != null){
				for (Integer menuId:menuIds){
					if (menuId != null){
						UserMenu eo = new UserMenu();
						eo.setUserId(userId);
						eo.setMenuId(menuId);
						userMenuService.add(eo);
					}
				}
			}
		}catch(Exception e){
			throw new UserException("系统错误，请稍后再试", e);
		}
	}

	/**
	 * 检查姓名是否已经注册
	 */
	public void check_username(String userName) {
		User eo = dao.selectByUserName(userName);
		if (eo != null){
			throw new UserException("姓名已经注册");
		}
	}

	/**
	 * 用户登录
	 */
	public User login(String userName, String password) {
		User eo = dao.selectByUserName(userName);
		if (eo == null){
			throw new UserException("用户不存在");
		}
		if (!eo.getPassword().equals(MD5Util.getMD5(password))){
			throw new UserException("密码错误");
		}
		
		return eo;
	}
	
	/**
	 * 用户修改
	 */
	public void edit(UserReo dto, User user) {
		
		//说明是密码修改, 需要检测原密码是否正确, 以及两次密码是否一致
		if (dto.getPassword3()!= null && !dto.getPassword3().equals("")){
			if (!MD5Util.getMD5(dto.getPassword()).equals(user.getPassword())){
				throw new UserException("原密码错误");
			}
			if (!dto.getPassword2().equals(dto.getPassword3())){
				throw new UserException("两次密码不一致");
			}
		}
		
		user.setAge(dto.getAge());
		user.setUserName(dto.getUserName());
		user.setPassword(MD5Util.getMD5(dto.getPassword3()));
		
		dao.updateByPrimaryKeySelective(user);
		
	}
	
	public User getById(Integer id) {
		return dao.selectByPrimaryKey(id);
	}

	public void edit(User eo) {
		
	}

	public void del(String ids) {
		
	}

	public int add(User eo) {
		return 0;
	}
} 
