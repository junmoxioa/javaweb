package com.ssm.controller;

import javax.servlet.http.HttpServletRequest;

import com.ssm.entity.Login;
import com.ssm.util.Base;

/**
 * Controller层的基本方法
 * @author ASUS
 *
 */
public class BaseController {

	/**
	 * 保存登录用户信息到session中
	 * @param request
	 * @param login
	 */
	public void setUserInfo(HttpServletRequest request, Login login){
		request.getSession().setAttribute(Base.USER_INFO, login);
	}
	
	/**
	 * 从session获取登录用户的信息
	 * @param request
	 * @return
	 */
	public Login getUserInfo(HttpServletRequest request){
		return (Login) request.getSession().getAttribute(Base.USER_INFO);
	}
	
	/**
	 * 从session删除登录用户的信息
	 * @param request
	 */
	public void delUserInfo(HttpServletRequest request){
		request.getSession().removeAttribute(Base.USER_INFO);
	}
	
}
