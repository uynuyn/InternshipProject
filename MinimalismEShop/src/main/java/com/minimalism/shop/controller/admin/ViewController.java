package com.minimalism.shop.controller.admin;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.minimalism.shop.cmn.service.impl.GroupProductServiceImpl;
import com.minimalism.shop.cmn.service.impl.ProductServiceImpl;
import com.minimalism.shop.entities.GroupProduct;

@Controller
@RequestMapping("/admins/view")
public class ViewController {
	
	@Autowired private GroupProductServiceImpl groupProductService;
	@Autowired private ProductServiceImpl productService;

	@RequestMapping(value = "product/single/{id}", method = RequestMethod.GET)
	public String product(Model model, @PathVariable("id") int id, HttpSession session) {
		GroupProduct groupProduct = groupProductService.findProductbyId(id);
		int qty = productService.countProductbyGroupProductandflag(groupProduct, true);
		model.addAttribute("groupProduct", groupProduct);
		model.addAttribute("qty", qty);
		return "view-single-product";
	}

}
