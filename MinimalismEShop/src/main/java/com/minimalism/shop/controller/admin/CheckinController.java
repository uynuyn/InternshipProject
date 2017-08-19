package com.minimalism.shop.controller.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.minimalism.shop.cmn.service.impl.CheckinServiceImpl;
import com.minimalism.shop.cmn.service.impl.DepartmentServiceImpl;
import com.minimalism.shop.cmn.service.impl.UserServiceImpl;
import com.minimalism.shop.dto.OrderProduct;
import com.minimalism.shop.entities.Category;
import com.minimalism.shop.entities.Department;
import com.minimalism.shop.entities.Order;

@Controller
public class CheckinController {
	
	@Autowired private CheckinServiceImpl checkinService;
	@Autowired private UserServiceImpl userService;
	@Autowired private DepartmentServiceImpl departmentService;

	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminHome(Model model,HttpSession session) {
		List<Order> listOrder = checkinService.findOrderbyStatusDay(false);
		List<Order> listPackage = checkinService.findOrderbyStatusDay(true);
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
		session.removeAttribute("admin");
		return "admin/home";
	}
		
	@RequestMapping(value = "/view-product-order/{id}", method = RequestMethod.GET)
	public String vieworder(Model model,HttpSession session, @PathVariable("id") int id) {
		Order order = checkinService.findOrderbyId(id);
		if(order.getStatus()!=null&& order.getStatus()){
			return "redirect:/admins/list-order";
		}
		OrderProduct orderProduct = checkinService.findOrderbyIdView(id);
		
		model.addAttribute("order", orderProduct);
		return "view-product-order";
	}
	@RequestMapping(value = "/view-product-order/{id}", method = RequestMethod.POST)
	public String vieworder(Model model, @PathVariable("id") int id) {
		Order order = checkinService.findOrderbyId(id);
		order.setStatus(true);
		checkinService.update(order);
//		goi mail cho khách hàng thong bao da chuyen hang
		StringBuilder message = new StringBuilder();
		message.append("Xin chào bạn "+ order.getUser().getFirstname()+ " " + order.getUser().getFirstname()+". \n");
		message.append("\n");
		message.append("Đơn hàng đang được vận chuyển. \n");
		message.append("\n");
		message.append("\n");
		message.append("\n");
		message.append("------------------------------------------\n");
		message.append("\n");
		message.append("\n");
		message.append("Minimalism Shop xin chân thành cảm ơn");
		userService.sendMail(order.getUser().getEmail(), message.toString());
		
		model.addAttribute("notification", "ship");

		
		return "redirect:/admins/list-order";			
		
	}
	
}
