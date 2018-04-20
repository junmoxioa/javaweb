package com.ssm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.ssm.dto.Result;
import com.ssm.dto.UserMenuReo;
import com.ssm.dto.UserReo;
import com.ssm.entity.Menu;
import com.ssm.entity.UserMenu;
import com.ssm.service.IMenuService;
import com.ssm.service.IUserMenuService;
import com.ssm.service.IUserService;

@Controller  
@RequestMapping("/user")
public class UserController extends BaseController{
	
    @Resource  
    private IUserService userService;
    @Resource  
    private IMenuService menuService;
    @Resource  
    private IUserMenuService userMenuService;
      
    /**
	 * 页面
	 * @param request
	 * @param model 
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(HttpServletRequest request,Model model){
        return "user/list";
    }
	
	/**
	 * 多条件查询
	 * @param request
	 * @param model
	 * @param page
	 * @param limit
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.POST,
			produces = {"application/json; charset=utf-8" })
    public String list(HttpServletRequest request,Model model,
    		UserReo dto){
		
		Map<String,Object> result = userService.list(dto);
		
        return JSON.toJSONString(result);
    }
	
	/**
	 * 密码修改页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/edit_psd", method = RequestMethod.GET)
	public String edit_psd(HttpServletRequest request,Model model){
        return "user/edit_psd";
    }
	
	/**
	 * 密码修改保存
	 * @param request
	 * @param model
	 * @param dto
	 * @return
	 */
	@RequestMapping(value = "/edit_psd", method = RequestMethod.POST)
    public String edit_psd(HttpServletRequest request,Model model,
    		UserReo dto){
		try{
			userService.edit(dto, getUserInfo(request).getUser());
			model.addAttribute("result", JSON.toJSONString(new Result<Object>(null, "操作成功")));
		}catch (Exception e){
			e.printStackTrace();
			model.addAttribute("result", JSON.toJSONString(new Result<Object>(e.getMessage())));
		}
		return "user/edit_psd";
    }
	
	/**
	 * 菜单权限配置页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/root_config", method = RequestMethod.GET)
	public String root_config(HttpServletRequest request,Model model,
			int id){
		try{
			Map<String, Object> result = new HashMap<String, Object>();
			
			List<Menu> menus = menuService.getAll();
			List<UserMenu> userMenus = userMenuService.getListByUserId(id);
			
			result.put("id", id);
			result.put("menus", menus);
			result.put("userMenus", userMenus);
			model.addAttribute("result", JSON.toJSONString(new Result<Map<String, Object>>(result,"操作成功")));
		}catch (Exception e){
			e.printStackTrace();
			model.addAttribute("result", JSON.toJSONString(new Result<Object>(e.getMessage())));
		}
		
        return "user/root_config";
    }
	
	/**
	 * 菜单权限配置保存
	 * @param request
	 * @param model
	 * @param eo
	 * @return
	 */
	@RequestMapping(value = "/root_config", method = RequestMethod.POST)
	public String root_config(HttpServletRequest request, Model model,
			UserMenuReo eo){
		try{
			userService.root_config(eo.getUserId(), eo.getMenuIds());
			model.addAttribute("result", JSON.toJSONString(new Result<Object>(null,"操作成功")));
		}catch (Exception e){
			e.printStackTrace();
			model.addAttribute("result", JSON.toJSONString(new Result<Object>(e.getMessage())));
		}
		
        return "user/root_config";
    }
	
	/**
	 * 检查用户名是否已经存在
	 * @param request
	 * @param model
	 * @param dto
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/check_username", method = RequestMethod.POST,
			produces = {"application/json; charset=utf-8" })
    public String check_username(HttpServletRequest request,Model model,
    		UserReo dto){
		try{
			userService.check_username(dto.getUserName());
			return JSON.toJSONString(new Result<Object>(null, ""));
		}catch (Exception e){
			e.printStackTrace();
			return JSON.toJSONString(new Result<Object>(e.getMessage()));
		}
    }
} 
