package com.minimalism.shop.controller;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.minimalism.shop.cmn.base.Common;
import com.minimalism.shop.cmn.service.impl.UserServiceImpl;
import com.minimalism.shop.cmn.validator.UserValidator;
import com.minimalism.shop.entities.User;

@Controller
public class UserController {
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@Autowired private UserValidator userValidator;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(userValidator);
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(HttpServletRequest request,
			@ModelAttribute("userFormRegister") @Validated  User users,
			final BindingResult result,
			Model model){
		if (result.hasErrors()) {
			return "register";
	    }
		User oldUser = new User();
		int salt = new Random().nextInt(100000);
		users.setSalt(salt);
		String pass = users.getPassword();
		users.setPassword(Common.passEncode(users.getPassword(),users.getSalt()));
		oldUser = userServiceImpl.findUserbyUsernameEmail(users.getUsername(), users.getEmail());
		if(Common.checkNullandBlank(oldUser)){
			users = userServiceImpl.save(users);
			users.setPassword(pass);
			if(users!=null){
				model.addAttribute("success", true);
				return "/home";
			}
		}
		users.setPassword("");
		model.addAttribute("result", "fail");
		return "register";
	}
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Model model) {
		model.addAttribute("userFormRegister" , new User());
		return "register";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request,
			@ModelAttribute("userFormLogin") @Validated  User users,
			final BindingResult result,
			Model model,
			HttpSession session){
		if (result.hasErrors()) {
			model.addAttribute("userFormLogin" , new User());
	    }
		
		User results = userServiceImpl.loginUser(users);
		if (!Common.checkNullandBlank(results)) {
			session.setAttribute("users", results);
			String check = (String) session.getAttribute("checkout");
			if("yes".equals(check)){
				return "redirect:/checkout";
			}
			return "redirect:/home";
		}
		
		model.addAttribute("fail", true);
		return "login";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model,HttpSession session) {
		session.removeAttribute("users");
		return "redirect:/home";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model){
		model.addAttribute("userFormLogin" , new User());
		return "login";
	}
	
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String products() {		
		return "common/products/list";
	}
	
	
	
}
