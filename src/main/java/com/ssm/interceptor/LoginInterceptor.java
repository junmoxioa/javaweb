package com.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ssm.entity.Login;
import com.ssm.util.Base;

/**
 * 用户未登录拦截
 * @author ASUS
 *
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Login user = (Login) request.getSession().getAttribute(Base.USER_INFO);
        System.out.println("未登录拦截 - LoginInterceptor/preHandle");
        if (user == null) {
            response.sendRedirect("/login");
            return false;
        }
        
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion");
    }
	
}
