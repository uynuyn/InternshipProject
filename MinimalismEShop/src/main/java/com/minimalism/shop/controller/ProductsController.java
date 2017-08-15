package com.minimalism.shop.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.minimalism.shop.cmn.base.Common;
import com.minimalism.shop.cmn.service.impl.CategoryServiceImpl;
import com.minimalism.shop.cmn.service.impl.DepartmentServiceImpl;
import com.minimalism.shop.cmn.service.impl.GroupProductServiceImpl;
import com.minimalism.shop.entities.Category;
import com.minimalism.shop.entities.GroupProduct;

@Controller
@RequestMapping("/products")
public class ProductsController {
	@Autowired
	public GroupProductServiceImpl groupProductService;

	@Autowired
	private CategoryServiceImpl categoryService;

	@Autowired
	private DepartmentServiceImpl departmentService;


	@RequestMapping(value = "/list/{departmentCode}", method = RequestMethod.GET)
	public String getAllListProduct(Model model, @PathVariable("departmentCode") String departmentCode) {
		List<Category> listCategory = departmentService.findProductbyCode(departmentCode).getCategories();
			model.addAttribute("listCategory", listCategory);
			model.addAttribute("breadcrumb" ,listCategory.get(0));			
		return "common/products/lists";
	}
	
	@RequestMapping(value = "/list/{department}/{categoryCode}", method = RequestMethod.GET)
	public String getAllListProduct(Model model, @PathVariable("department") String departmentCode,
			@PathVariable("categoryCode") String categoryCode) {
		List<GroupProduct> listProduct = new ArrayList<>();
		if(categoryCode!=null){
			listProduct = categoryService.findProductbyCodeofCategory(categoryCode).getGroupProducts();			
		}
			model.addAttribute("breadcrumb" ,listProduct.get(0));
			model.addAttribute("listProduct", listProduct);
		return "common/products/list";
	}
	
	
	
	@RequestMapping(value = "/list/search", method = RequestMethod.GET)
	public String getSearchListProduct(Model model, HttpServletRequest request) {
		String key = request.getParameter("keyword");
		List<GroupProduct> listProduct = new ArrayList<>();
		String name  = Common.removeAccent(key);
		
		String name1 = name.replaceAll(" ", "");
		listProduct = groupProductService.searchProduct(name1);
		if(Common.checkListNullandBlank(listProduct)){
			String[] split = name.split(" ");
			for(int i = 0 ; i < split.length; i++){
				List<GroupProduct> tam = groupProductService.searchProduct(split[i]);
				listProduct.addAll(tam);
			}
			
		}
		model.addAttribute("f", true);
		model.addAttribute("listProduct", listProduct);
		return "common/products/list";
	}
}
