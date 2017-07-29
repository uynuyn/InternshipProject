package com.minimalism.shop.controller;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.minimalism.shop.cmn.base.Common;
import com.minimalism.shop.cmn.service.impl.UserServiceImpl;
import com.minimalism.shop.entities.User;

@Controller
public class UserController {
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(HttpServletRequest request,
			@ModelAttribute("userFormRegister") @Validated  User users,
			final BindingResult result,
			Model model){
		if (result.hasErrors()) {
			model.addAttribute("userFormRegister" , new User());
	    }
		User oldUser = new User();
		int salt = new Random().nextInt(100000);
		users.setSalt(salt);
		users.setPassword(Common.passEncode(users.getPassword(),users.getSalt()));
		oldUser = userServiceImpl.findUserbyUsername(users.getUsername(), users.getEmail());
		if(Common.checkNullandBlank(oldUser)){
			users = userServiceImpl.save(users);
			if(users==null){
				model.addAttribute("result", "thanh cong");
				return "redirect:/home";
			}
		}
		
		return "common/register";
	}
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Model model) {
		model.addAttribute("userFormRegister" , new User());
		return "common/register";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request,
			@ModelAttribute("userFormLogin") @Validated  User users,
			final BindingResult result,
			Model model){
		if (result.hasErrors()) {
			model.addAttribute("userFormLogin" , new User());
	    }
		
		boolean results = userServiceImpl.loginUser(users);
		if (results) {
			model.addAttribute("result", "thanh cong");
			return "redirect:/home";
		}
		
		
		return "common/login";
	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("userFormLogin" , new User());
		return "common/login";
	}
	
	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public String cart() {		
		return "common/cart";
	}
	
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String products() {		
		return "common/products/list";
	}
	
	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public String checkout() {		
		return "common/checkout";
	}
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminHome() {		
		return "admin/home";
	}
}
