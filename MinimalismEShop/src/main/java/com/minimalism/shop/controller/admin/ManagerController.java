package com.minimalism.shop.controller.admin;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.minimalism.shop.cmn.service.impl.CategoryServiceImpl;
import com.minimalism.shop.cmn.service.impl.CheckinServiceImpl;
import com.minimalism.shop.cmn.service.impl.GroupProductServiceImpl;
import com.minimalism.shop.cmn.service.impl.ProductServiceImpl;
import com.minimalism.shop.dto.AddGroupProductDto;
import com.minimalism.shop.entities.Category;
import com.minimalism.shop.entities.GroupProduct;
import com.minimalism.shop.entities.Order;
import com.minimalism.shop.entities.Product;

@Controller
@RequestMapping("/admins")
public class ManagerController {

	@Autowired private CheckinServiceImpl checkinService;
	
	@Autowired private CategoryServiceImpl categoryService;
	
	@Autowired private GroupProductServiceImpl groupProductService;
	
	@Autowired private ProductServiceImpl productService;
	
	@RequestMapping(value = "/list-order", method = RequestMethod.GET)
	public String listOrder(Model model, HttpServletRequest request) {
		String date = request.getParameter("dateOrder");
		List<Order> listOrder = new ArrayList<>();
		if(date==null || date.equals("")){
			listOrder = checkinService.findOrderbyStatusDay();
		}else {
			Date date2 = null;
			try {
				date2 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
				listOrder = checkinService.findOrderbyDate(date2);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		model.addAttribute("listOrder", listOrder);
		return "list-order";
	}
	
	@RequestMapping(value = "/add-product", method = RequestMethod.GET)
	public String adminaddProduct(Model model) {
		model.addAttribute("addproductForm" , new AddGroupProductDto());
		List<Category> categories = categoryService.findAllList();
		
		model.addAttribute("listCategory", categories);
		return "add-product";
	}
	
	@RequestMapping(value = "/add-product", method = RequestMethod.POST)
	public String adminaddProduct(Model model,HttpServletRequest request,
			@ModelAttribute("addproductForm") @Validated AddGroupProductDto addGroupProduct,
			final BindingResult result) {
		if (result.hasErrors()) {
			model.addAttribute("addproductForm" , new AddGroupProductDto());
	    }
		
		
		
		GroupProduct groupProduct = new GroupProduct();
		Category category = new Category();
		category.setId(addGroupProduct.getIdCategory());
		groupProduct.setName(addGroupProduct.getName());
		groupProduct.setCategory(category);
		groupProduct.setDescription(addGroupProduct.getDescription());
		if(addGroupProduct.getSize()!=0){
			groupProduct.setSize(addGroupProduct.getSize());
		}
		groupProduct.setEndProduct(true);
		groupProduct.setImge(addGroupProduct.getImage());
		groupProduct.setPrice(addGroupProduct.getPrice());
		
		groupProduct = groupProductService.save(groupProduct);
		
		
		
		int qty = addGroupProduct.getQty();
		for(int i = 0 ; i < qty ; i++){
			Product product = new Product();
			product.setGroupProduct(groupProduct);
			product.setFlag(true);
			productService.save(product);
		}
		
		return "add-product";
	}
	
	

	@RequestMapping(value = "/listview", method = RequestMethod.GET)
	public String adminlistview(Model model) {
		
		return "listview";
	}

	@RequestMapping(value = "/import-store", method = RequestMethod.GET)
	public String adminimportStore(Model model) {
		
		return "import-store";
	}

	@RequestMapping(value = "/add-promotion", method = RequestMethod.GET)
	public String adminaddPromotion(Model model) {
		
		return "add-promotion";
	}
	
	@RequestMapping(value = "/update-product", method = RequestMethod.GET)
	public String adminupdateProduct(Model model) {
		return "update-product";
	}
		
}
