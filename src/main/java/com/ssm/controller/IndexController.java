package com.ssm.controller;


import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;
import com.ssm.dto.Result;
import com.ssm.dto.UserReo;
import com.ssm.entity.Login;
import com.ssm.entity.Menu;
import com.ssm.entity.User;
import com.ssm.service.IMenuService;
import com.ssm.service.IUserMenuService;
import com.ssm.service.IUserService;

@Controller  
@RequestMapping("")
public class IndexController extends BaseController{

	@Resource  
    private IUserService userService;
	@Resource
    private IMenuService menuService;
    @Resource
    private IUserMenuService userMenuService;
	
	/**
	 * 首页
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(HttpServletRequest request,Model model){
        return "root/index";
    }
	
	/**
	 * 第一个tab
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/first", method = RequestMethod.GET)
    public String frist(HttpServletRequest request,Model model){
        return "root/first";
    }
	
	/**
	 * 注册
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(HttpServletRequest request,Model model){
        return "root/register";
    }
	
	/**
	 * 注册保存
	 * @param request
	 * @param model
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(HttpServletRequest request,Model model,
    		UserReo dto){
		try{
			userService.add(dto);
			model.addAttribute("result", JSON.toJSONString(new Result<User>(null, "注册成功")));
		}catch(Exception e){
			e.printStackTrace();
			model.addAttribute("result", JSON.toJSONString(new Result<User>(e.getMessage())));
		}
		return "root/register";
    }
	
	/**
	 * 登录页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(HttpServletRequest request,Model model){
        return "root/login";
    }
	
	/**
	 * 登录验证
	 * @param request
	 * @param model
	 * @param dto
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request,Model model,
    		UserReo dto){
		try{
			User eo = userService.login(dto.getUserName(), dto.getPassword());
			login_success(eo, request);
			model.addAttribute("result", JSON.toJSONString(new Result<User>(null, "登录成功")));
		}catch(Exception e){
			e.printStackTrace();
			model.addAttribute("result", JSON.toJSONString(new Result<User>(e.getMessage())));
		}
        return "root/login";
    }
	
	/**
	 * 登录成功操作
	 * @param eo
	 * @param request
	 */
	private void login_success(User eo, HttpServletRequest request){
		//将用户信息和用户对应的菜单放入登录对象在保存到session中
		List<Menu> list = menuService.getMenuByUser(eo);
		Login login = new Login(eo, list);
		setUserInfo(request, login);
	}
	
	/**
	 * 退出登录
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request,Model model){
		delUserInfo(request);
        return "root/login";
    }
}
