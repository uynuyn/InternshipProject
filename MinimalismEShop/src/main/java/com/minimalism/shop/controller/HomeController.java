package com.minimalism.shop.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.minimalism.shop.cmn.base.Common;
import com.minimalism.shop.cmn.service.impl.AprioriServiceImpl;
import com.minimalism.shop.cmn.service.impl.DepartmentServiceImpl;
import com.minimalism.shop.cmn.service.impl.GroupProductServiceImpl;
import com.minimalism.shop.entities.Department;
import com.minimalism.shop.entities.GroupProduct;

@Controller
public class HomeController {
	
	
	@Autowired private GroupProductServiceImpl groupProductService;
		
	@Autowired private DepartmentServiceImpl departmentService;
	
	@Autowired private AprioriServiceImpl aprioriService;
	
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
		return "common/home";
	}
	
	
	

}
