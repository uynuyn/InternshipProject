package com.minimalism.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CartController {
	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public String checkout() {
		// lấy thong tin dang nhập
		return "common/checkout";
	}
	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public String cart() {		
		return "common/cart";
	}

}
