package com.minimalism.shop.cmn.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.minimalism.shop.cmn.repository.impl.PermissionRepositoryImpl;
import com.minimalism.shop.entities.Permission;
import com.minimalism.shop.entities.User;

public class AdminInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private PermissionRepositoryImpl permissionRepository;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession session = request.getSession();
		String url = request.getRequestURI();

		if (url.contains("admin") || url.contains("del 	ivery")) {
			session.setAttribute("admin", "isadmin");
			if (session.getAttribute("users") == null) {
				response.sendRedirect("/shop/login");
				return false;
			} else {
				String admin = (String) session.getAttribute("admin");
				if (admin != null) {
					User user = (User) session.getAttribute("users");
					List<Permission> permissions = permissionRepository.findRolebyUser(user);
					if (permissions.size() == 0 || permissions == null) {
						response.sendRedirect("/shop/login");
						return false;
					}else {
						if (url.contains("delivery")) {
							for (Permission permission : permissions) {
								if (permission.getRole().getRole().equals("ROLE_DELIVER")) {
									return true;
								}
							}
							response.sendRedirect("/shop/admin");
							return false;
						} 
						if (url.contains("admins")) {
							for (Permission permission : permissions) {
								if (permission.getRole().getRole().equals("ROLE_ADMIN")
										|| permission.getRole().getRole().equals("ROLE_STAFF")) {
									return true;
								}
							}
							response.sendRedirect("/shop/admin");
							return false;

						}
					}
				}
			}
			session.removeAttribute("admin");
		}
		
		return true;
	}
}
