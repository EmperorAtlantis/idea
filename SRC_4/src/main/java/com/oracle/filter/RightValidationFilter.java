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

//import org.apache.log4j.chainsaw.Main;

import com.oracle.entitys.Employee;

public class RightValidationFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse reseponse, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) reseponse;

		String url = req.getServletPath();
		Employee user = (Employee) req.getSession().getAttribute("user");

		if (user != null) {
			Integer jobInfoId = user.getJobInfoId();

			if (url.contains("usermanage")) {
				if (jobInfoId == 1 || jobInfoId == 2) {
					chain.doFilter(request, reseponse);
				} else {
					resp.sendRedirect("error.jsp");
				}
			} else if (url.contains("report")) {
				if ((jobInfoId == 1 || jobInfoId == 3 || jobInfoId == 5 || jobInfoId == 7 || jobInfoId == 8)) {
					chain.doFilter(request, reseponse);
				} else {
					resp.sendRedirect("error.jsp");
				}
			} else if (url.contains("customdata")) {
				if (jobInfoId == 7 || jobInfoId == 5) {
					chain.doFilter(request, reseponse);
				} else {
					resp.sendRedirect("error.jsp");
				}
			} else if (url.contains("customdev")) {
				if ((jobInfoId == 5 || jobInfoId == 6 || jobInfoId == 8 || jobInfoId == 9)) {
					chain.doFilter(request, reseponse);
				} else {
					resp.sendRedirect("error.jsp");
				}
			} else if (url.contains("ustomconsult")) {
				if ((jobInfoId == 3 || jobInfoId == 4)) {
					chain.doFilter(request, reseponse);
				} else {
					resp.sendRedirect("error.jsp");
				}
			} else if (url.contains("department")) {
				if ((jobInfoId == 4 || jobInfoId == 6 || jobInfoId == 9)) {
					chain.doFilter(request, reseponse);
				} else {
					resp.sendRedirect("error.jsp");
				}
			} else if (url.contains("count")) {
				if ((jobInfoId == 3 || jobInfoId == 5 ||jobInfoId == 8|| jobInfoId == 9)) {
					chain.doFilter(request, reseponse);
				} else {
					resp.sendRedirect("error.jsp");
				}
			}
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
