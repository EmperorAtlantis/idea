package com.oracle.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginValidationFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		//判断是否登录
		//需要强转回HttpServletRequest类型
		HttpServletRequest request = 
				(HttpServletRequest)req;
		HttpSession session = request.getSession(false);
		if(session==null ||
				session.getAttribute("user")==null){
			//没登录，对不起，请去登录页面登录
			HttpServletResponse response = 
					(HttpServletResponse)resp;
			response.sendRedirect("login.jsp");
		}else{
			//如果已登录，放行
			chain.doFilter(req, resp);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}

