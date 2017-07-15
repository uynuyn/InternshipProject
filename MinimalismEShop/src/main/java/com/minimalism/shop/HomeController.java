package com.minimalism.shop;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home() {		
		return "commmon/home";
	}
	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public String cart() {		
		return "common/cart";
	}
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String products() {		
		return "common/products/list";
	}
	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public String product() {		
		return "common/products/single";
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
