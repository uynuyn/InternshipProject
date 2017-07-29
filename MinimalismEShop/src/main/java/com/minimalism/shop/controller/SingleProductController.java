package com.minimalism.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.minimalism.shop.cmn.service.impl.GroupProductServiceImpl;
import com.minimalism.shop.entities.GroupProduct;

@Controller
@RequestMapping("/product")
public class SingleProductController {
	@Autowired
	private GroupProductServiceImpl groupProductService;
	
	@RequestMapping(value = "/single/{id}", method = RequestMethod.GET)
	public String product(Model model , @PathVariable("id") int id) {
		GroupProduct groupProduct = groupProductService.findProductbyId(id);
		model.addAttribute("groupProduct", groupProduct);
		return "common/products/single";
	}

}
