package com.minimalism.shop.controller;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.minimalism.shop.cmn.service.impl.UserServiceImpl;
import com.minimalism.shop.cmn.validator.UserValidator;
import com.minimalism.shop.entities.User;

@Controller
public class UserController {
	@Autowired
	private UserServiceImpl userService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserValidator userValidator;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(userValidator);
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(HttpSession session, @ModelAttribute("userFormRegister") @Validated User users,
			final BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "register";
		}

		boolean oldUser = userService.findUserbyUsernameEmail(users.getUsername(), users.getEmail());
		if (!oldUser) {// if check = true allow save user
			session.setAttribute("verify", users);

			return "redirect:/verify";
		}
		users.setPassword("");
		model.addAttribute("result", "fail");
		return "register";
	}

	@RequestMapping(value = "/verify", method = RequestMethod.GET)
	public String verify(HttpSession session, HttpServletResponse response) {
		int rand = new Random().nextInt(100000);
		User user = (User) session.getAttribute("verify");
		StringBuilder message = new StringBuilder();

		message.append("<p style='font-size:36px;'><img src='cid:identifier1234' width='90' height='90'>"
				+ "Xin chào bạn " + user.getUsername() + "</p>");
		message.append("<h2 style='color: #262626'>Cảm ơn bạn đã quan tâm đến cửa hàng của chúng tôi.</h2>");
		message.append("<h2 style='color: #999999'>Mã xác nhận tài khoản của bạn là : <i style='color: #FF6666;'>"
				+ rand + " </i>.</h2>");
		message.append("<hr>");
		message.append("Minimalism Shop xin chân thành cảm ơn");

		userService.sendMail(user.getEmail(), message.toString());
		user.setPoint(rand);
		session.setAttribute("verify", user);
		return "verify";
	}

	/**
	 * @param session
	 * @param model
	 * @param verify
	 * @return
	 */

	@RequestMapping(value = "/verify", method = RequestMethod.POST)
	public String verify(HttpSession session, Model model, @RequestParam("verify") String verify) {

		User user = (User) session.getAttribute("verify");
		session.removeAttribute("verify");
		if (verify.trim().equals(String.valueOf(user.getPoint()))) {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			user.setPoint(0);
			user = userService.save(user);
			if (user != null) {
				session.setAttribute("users", user);
				model.addAttribute("thanhcong", false);
				return "redirect:/home";
			}
		}
		model.addAttribute("fail", true);
		return "verify";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Model model) {
		model.addAttribute("userFormRegister", new User());
		return "register";
	}

	/*
	 * @RequestMapping(value = "/login", method = RequestMethod.POST) public
	 * String login(HttpServletRequest request,
	 * 
	 * @ModelAttribute("userFormLogin") @Validated User users, final
	 * BindingResult result, Model model, HttpSession session){ if
	 * (result.hasErrors()) { model.addAttribute("userFormLogin" , new User());
	 * } User results = userService.loginUser(users); if
	 * (!Common.checkNullandBlank(results)) { session.setAttribute("users",
	 * results); String check = (String) session.getAttribute("checkout");
	 * if("yes".equals(check)){ return "redirect:/checkout"; }else { String
	 * isadmin = (String) session.getAttribute("admin");
	 * 
	 * if("isadmin".equals(isadmin)){ return "redirect:/admin"; } } return
	 * "redirect:/home"; }
	 * 
	 * model.addAttribute("fail", true); return "login"; }
	 */

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		session.removeAttribute("users");
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/home";
	}

	@RequestMapping(value = "/login", method =  RequestMethod.GET)
	public String login() {
		
		return "login";
	}

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String products() {
		return "common/products/list";
	}

}
