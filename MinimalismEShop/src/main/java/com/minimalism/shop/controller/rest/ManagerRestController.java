package com.minimalism.shop.controller.rest;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.minimalism.shop.cmn.service.impl.GroupProductServiceImpl;
import com.minimalism.shop.entities.GroupProduct;

@RestController
@RequestMapping("manager")
public class ManagerRestController {
	
	@Autowired private GroupProductServiceImpl groupProductService;
	
	@RequestMapping(value ="/findName/{idCategory}" , method = RequestMethod.POST)
	public @ResponseBody List<String> findname(Model model ,
			HttpServletRequest request,
			@PathVariable("idCategory") int idCategory){
		List<GroupProduct> groupProducts = groupProductService.findProductbyCategory(idCategory);
		List<String> nameProduct= new ArrayList<>();
		for (GroupProduct groupProduct : groupProducts) {
			nameProduct.add(groupProduct.getName());
		}
		return nameProduct;
	}
	
	
}
