package com.minimalism.shop.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.minimalism.shop.cmn.base.Common;
import com.minimalism.shop.cmn.service.impl.GroupProductServiceImpl;
import com.minimalism.shop.dto.ProductDto;
import com.minimalism.shop.entities.GroupProduct;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired	private GroupProductServiceImpl groupProductService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/addCart/{id}/{qty}", method = RequestMethod.POST)
	public @ResponseBody void addCart(Model model, HttpSession session, 
			@PathVariable("id") int id,
			@PathVariable("qty") int qty){
		GroupProduct groupProduct = groupProductService.findProductbyId(id);
		Map<Integer, ProductDto> mapItem = (Map<Integer, ProductDto>) session.getAttribute("cart");
		ProductDto product = new ProductDto();
		if(mapItem==null){
			mapItem = new HashMap<>();
			product.setId(groupProduct.getId());
			product.setName(groupProduct.getName());
			product.setPrice(groupProduct.getPrice());
			product.setQuantity(qty);
			product.setImgPath(groupProduct.getImge());
			product.setDiscount(0);
		}else{
			product = mapItem.get(id);
			if(Common.checkNullandBlank(product)){
				product = new ProductDto();
				product.setId(groupProduct.getId());
				product.setName(groupProduct.getName());
				product.setPrice(groupProduct.getPrice());
				product.setQuantity(qty);
				product.setImgPath(groupProduct.getImge());
				product.setDiscount(0);
			}else {
				int quantity = mapItem.get(id).getQuantity() + 1;
				if(quantity <= groupProduct.getQuantity()){
					mapItem.get(id).setQuantity(quantity);
				}
			}
		}
		mapItem.put(groupProduct.getId(), product);
		session.setAttribute("cart", mapItem);
	}
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/remove/{id}")
	private @ResponseBody void remove(HttpServletRequest request, @PathVariable("id") int id) {
		HttpSession session = request.getSession();
		Map<Integer, ProductDto> listProduct = (Map<Integer, ProductDto>) session.getAttribute("cart");

		if (listProduct != null) {
			listProduct.remove(id);
		}
	}

	
	
}
