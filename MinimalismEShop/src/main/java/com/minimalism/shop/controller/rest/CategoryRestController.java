package com.minimalism.shop.controller.rest;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.minimalism.shop.cmn.service.impl.CategoryServiceImpl;
import com.minimalism.shop.entities.Category;

@RestController
public class CategoryRestController {
	@Autowired private CategoryServiceImpl categoryService;
	
	public @ResponseBody List<String> category(Model model, HttpServletRequest request, @PathVariable("idDepartment") int department){
		List<Category> categories = categoryService.findCategoryDepartment(department);
		List<String> list = new ArrayList<>();
		for (Category category : categories) {
			list.add(category.getName());
		}
		
		return null;
		
	}
	
	
}
