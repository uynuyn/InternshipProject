package com.minimalism.shop.cmn.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.minimalism.shop.dto.ProductDto;


public class AuthenticateInterceptor extends HandlerInterceptorAdapter{
	@SuppressWarnings("unchecked")
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		String url = request.getRequestURI();
		Map<Integer, ProductDto> listProduct = (Map<Integer, ProductDto>) session.getAttribute("cart");


		if(url.contains("checkout")){
			session.removeAttribute("checkout");
			if(listProduct== null || listProduct.isEmpty()){
				response.sendRedirect("/shop/home");
				return false;
			}
			if(session.getAttribute("users") == null){
				session.setAttribute("checkout", "yes");
				response.sendRedirect("/shop/login");
				return false;
			}
			
		}
		
		return true;
	}
}
