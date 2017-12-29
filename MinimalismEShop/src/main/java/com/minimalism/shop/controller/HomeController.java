package com.minimalism.shop.controller;

import java.util.Calendar;
import java.util.Date;
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
import com.minimalism.shop.cmn.service.impl.KMeanSercivesImpl;
import com.minimalism.shop.cmn.service.impl.KMeanServiceImpl;
import com.minimalism.shop.cmn.service.impl.UserServiceImpl;
import com.minimalism.shop.dto.InvolveDto;
import com.minimalism.shop.entities.Department;
import com.minimalism.shop.entities.GroupProduct;
import com.minimalism.shop.entities.User;



@Controller
public class HomeController {
	
	
	@Autowired private GroupProductServiceImpl groupProductService;
		
	@Autowired private DepartmentServiceImpl departmentService;
	
	@Autowired private AprioriServiceImpl aprioriService;
	
	@Autowired private UserServiceImpl userService;
	
	@Autowired private KMeanServiceImpl kMeanService;
	
	@Autowired private KMeanSercivesImpl kMeanServices;
	

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
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		cal.set(Calendar.MONTH, cal.get(Calendar.MONTH)-2);
		Date date = cal.getTime();
		System.out.println(date);
		List<GroupProduct> list = groupProductService.findListProductTop(date);
		model.addAttribute("products", list);
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Model model, HttpSession session) {
		getProductTop(model);
		getAllListProduct(session);
		aprioriService.findAllList();
		
		HotProduct();
		
		User user2 = new User();
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof org.springframework.security.core.userdetails.User) {
			org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) principal;
			String name = user.getUsername(); // get logged in username
			user2 = userService.findUserbyUsername(name);
			List<GroupProduct> groupProducts = kMeanService.kMeanProduct(user2);
			session.setAttribute("users", user2);
			model.addAttribute("kMeanProducts", groupProducts);
		}
		
		return "common/home";
	}
	
	/*@RequestMapping(value = "/login/google", method = RequestMethod.GET)
	public String loginGoogle() {
		return "login/google";
	}
	
	@RequestMapping(value = "/login/google", method = RequestMethod.POST)
	public String loginGoogle(Model model, HttpSession session) {
		String user = (String) session.getAttribute("gogo");
		System.out.println(user);
		return "common/home";
	}*/
	public void HotProduct(){
		for (InvolveDto involve : kMeanServices.findListProductYear()) {
			System.out.println(involve.getIdGroupProduct()+ " - " +involve.getNumber()+" - "+involve.getYear()+"______________________________________");
			GroupProduct groupProduct = groupProductService.findProductbyId(involve.getIdGroupProduct());
			groupProduct.setIsSpecial(true);
			groupProductService.update(groupProduct);
		}
	}
	

}
