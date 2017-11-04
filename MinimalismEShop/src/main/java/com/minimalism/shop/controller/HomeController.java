package com.minimalism.shop.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.minimalism.shop.cmn.base.Common;
import com.minimalism.shop.cmn.service.impl.AprioriServiceImpl;
import com.minimalism.shop.cmn.service.impl.DepartmentServiceImpl;
import com.minimalism.shop.cmn.service.impl.GroupProductServiceImpl;
import com.minimalism.shop.cmn.service.impl.UserServiceImpl;
import com.minimalism.shop.entities.Department;
import com.minimalism.shop.entities.GroupProduct;
import com.minimalism.shop.entities.User;

@Controller
public class HomeController {
	
	
	@Autowired private GroupProductServiceImpl groupProductService;
		
	@Autowired private DepartmentServiceImpl departmentService;
	
	@Autowired private AprioriServiceImpl aprioriService;
	
	@Autowired private UserServiceImpl userService;
	
	@PostConstruct
	public void homeController(){
	}
	
	public void getAllListProduct(HttpSession session){
		
		List<Department> listDepartment = departmentService.findAllList();
		if(!Common.checkListNullandBlank(listDepartment)){
			session.setAttribute("listDepartment", listDepartment);
		}
	}
	
	
	private void getProductTop(Model model){
		List<GroupProduct> list = groupProductService.findListProductTop();
		model.addAttribute("products", list);
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Model model, HttpSession session) {
		getProductTop(model);
		getAllListProduct(session);
		aprioriService.findAllList();
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof org.springframework.security.core.userdetails.User) {
			org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) principal;
			String name = user.getUsername(); // get logged in username
			User user2 = new User();
			user2 = userService.findUserbyUsername(name);
			session.setAttribute("users", user2);
		}
		return "common/home";
	}
	
	@RequestMapping(value = "/login/google", method = RequestMethod.GET)
	public String loginGoogle() {
		return "login/google";
	}
	
	@RequestMapping(value = "/login/google", method = RequestMethod.POST)
	public String loginGoogle(Model model, HttpSession session) {
		String user = (String) session.getAttribute("gogo");
		System.out.println(user);
		return "common/home";
	}
	

}
