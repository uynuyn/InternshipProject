package com.minimalism.shop.cmn.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AdminInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		String url = request.getRequestURI();


		if(url.contains("admin")){
			if(session.getAttribute("users") == null){
				response.sendRedirect("/shop/login");
				return false;
			}
		}
		return true;
	}
}

