package com.minimalism.shop.controller.rest;

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
import com.minimalism.shop.cmn.service.impl.ProductServiceImpl;
import com.minimalism.shop.dto.ProductDto;
import com.minimalism.shop.dto.ViewCart;
import com.minimalism.shop.entities.GroupProduct;

@RestController
@RequestMapping("/cart")
public class CartRestController {

	@Autowired	private GroupProductServiceImpl groupProductService;
	
	@Autowired private ProductServiceImpl productService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/addCart/{id}/{qty}", method = RequestMethod.POST)
	public @ResponseBody Integer addCart(Model model, HttpSession session, 
			@PathVariable("id") int id,
			@PathVariable("qty") int qty){
		session.removeAttribute("viewCart");
		ViewCart viewCart = new ViewCart();
		GroupProduct groupProduct = groupProductService.findProductbyId(id);
		int productQty = productService.countProductbyGroupProductandflag(groupProduct, true);
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
				if(quantity <= productQty){
					mapItem.get(id).setQuantity(quantity);
				}
			}
		}
		Double amount = 0.0;
		Integer integer = 0;
		mapItem.put(groupProduct.getId(), product);
		for (ProductDto productDto : mapItem.values()) {
			amount += productDto.getQuantity()*productDto.getPrice();
			integer += productDto.getQuantity();
		}
		viewCart.setAmount(amount);
		viewCart.setQty(integer);
		session.setAttribute("viewCart", viewCart);
		session.setAttribute("cart", mapItem);
		return integer;
	}
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/remove/{id}")
	private @ResponseBody Integer remove(HttpServletRequest request, @PathVariable("id") int id) {
		HttpSession session = request.getSession();
		session.removeAttribute("viewCart");
		Map<Integer, ProductDto> listProduct = (Map<Integer, ProductDto>) session.getAttribute("cart");
		if (listProduct != null) {
			listProduct.remove(id);
		}
		Double amount = 0.0;
		Integer integer = 0;
		ViewCart viewCart = new ViewCart();
		for (ProductDto productDto : listProduct.values()) {
			amount += productDto.getQuantity()*productDto.getPrice();
			integer += productDto.getQuantity();
		}
		viewCart.setAmount(amount);
		viewCart.setQty(integer);
		session.setAttribute("viewCart", viewCart);
		return integer;
	}

	
	
}
