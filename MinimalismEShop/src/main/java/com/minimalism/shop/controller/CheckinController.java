package com.minimalism.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.minimalism.shop.cmn.service.impl.CheckinServiceImpl;
import com.minimalism.shop.entities.Order;

@Controller
public class CheckinController {
	
	@Autowired private CheckinServiceImpl checkinService;
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminHome(Model model) {
		List<Order> listOrder = checkinService.findOrderbyStatusDay();
		model.addAttribute("numberOrder", listOrder.size());
		
		return "admin/home";
	}
	
}
