package com.minimalism.shop.controller.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.minimalism.shop.cmn.base.Common;
import com.minimalism.shop.cmn.repository.impl.PermissionRepositoryImpl;
import com.minimalism.shop.cmn.service.impl.CheckinServiceImpl;
import com.minimalism.shop.cmn.service.impl.DepartmentServiceImpl;
import com.minimalism.shop.entities.Category;
import com.minimalism.shop.entities.Department;
import com.minimalism.shop.entities.Order;
import com.minimalism.shop.entities.Permission;
import com.minimalism.shop.entities.User;

@Controller
public class AdminController {
	
	@Autowired private CheckinServiceImpl checkinService;
	@Autowired private DepartmentServiceImpl departmentService;
	@Autowired private PermissionRepositoryImpl permissionRepository;

	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminHome(Model model,HttpSession session) {
		List<Order> listOrder = checkinService.findOrderbyStatusDay(false);
		List<Order> listPackage = checkinService.findOrderbyStatusDay(true);
		User user = (User) session.getAttribute("users");
		List<Permission> permissions = permissionRepository.findRolebyUser(user);
		if(!Common.checkListNullandBlank(permissions)){
			for (Permission permission : permissions) {
				if(permission.getRole().getRole().equals("ROLE_DELIVER")){
					model.addAttribute("delivery", "delivery");
				}
			}
		}
		List<Category> listCategory = new ArrayList<>();
		for (Department department: departmentService.findAllList()) {
			for(Category category : department.getCategories()){
				listCategory.add(category);
			}
		}
		if(listCategory!=null){
			model.addAttribute("listCategory", listCategory);
		}
		model.addAttribute("numberOrder", listOrder.size());
		model.addAttribute("numberPackage", listPackage.size());
		return "admin/home";
	}
		
	
}
