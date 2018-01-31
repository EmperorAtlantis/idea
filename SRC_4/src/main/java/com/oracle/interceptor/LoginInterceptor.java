package com.oracle.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.oracle.entitys.Employee;

public class LoginInterceptor extends HandlerInterceptorAdapter{

	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		boolean flag=true;
		
		
		HttpSession session = request.getSession(false);
		
		
		
		if(session==null||session.getAttribute("user")==null){
			System.out.println("未登录  跳转到登陆页面");
			flag=false;
			response.sendRedirect("login.jsp");
			
		}
		
		return flag;
	}
	
	
}
