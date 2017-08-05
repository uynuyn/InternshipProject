package com.minimalism.shop.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.minimalism.shop.cmn.service.impl.CheckoutServiceImpl;
import com.minimalism.shop.cmn.service.impl.GroupProductServiceImpl;
import com.minimalism.shop.cmn.service.impl.ProductServiceImpl;
import com.minimalism.shop.cmn.service.impl.UserServiceImpl;
import com.minimalism.shop.dto.CheckoutDto;
import com.minimalism.shop.dto.ProductDto;
import com.minimalism.shop.entities.GroupProduct;
import com.minimalism.shop.entities.Order;
import com.minimalism.shop.entities.OrderDetail;
import com.minimalism.shop.entities.Product;
import com.minimalism.shop.entities.User;

@Controller
public class CartController {
	
	@Autowired private CheckoutServiceImpl checkoutService;
	
	@Autowired private UserServiceImpl userService;
	
	@Autowired private ProductServiceImpl productService;
	
	@Autowired private GroupProductServiceImpl groupProductService;
	
	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public String checkout(Model model) {
		model.addAttribute("checkoutForm" , new CheckoutDto());
		return "common/checkout";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/checkout", method = RequestMethod.POST)
	public String checkoutForm(HttpServletRequest request, 
			@ModelAttribute("checkoutForm") @Validated CheckoutDto checkoutDto,
			final BindingResult result,
			Model model,HttpSession session) {
		if (result.hasErrors()) {
			model.addAttribute("checkoutForm" , new CheckoutDto());
	    }
		User user = (User) session.getAttribute("users");
		user.setFirstname(checkoutDto.getFirstname());
		user.setLastname(checkoutDto.getLastname());
		user.setPhone(checkoutDto.getPhone());
		user.setAddressStreet(checkoutDto.getAddressStreet());
		user.setAddressSuite(checkoutDto.getAddressSuite());
		user.setAddressCity(checkoutDto.getAddressCity());
		userService.updateUser(user);
		
		
		Order order = new Order();
		order.setUser(user);
		order.setAddress(checkoutDto.getAddressStreet() +" " + checkoutDto.getAddressSuite() + " "+ checkoutDto.getAddressCity());
//		Order order2 = checkoutService.findOrderofUserinDate(order);
//		if(Common.checkNullandBlank(order2)){
			order = checkoutService.orderInforNew(order);
//		}else {
//			order = order2;
//		}
		
		Map<Integer, ProductDto> mapItem = (Map<Integer, ProductDto>) session.getAttribute("cart");
		for (ProductDto productDto : mapItem.values()) {
			GroupProduct groupProduct = groupProductService.findProductbyId(productDto.getId());
			List<Product> products = productService.findProductbyGroupProductandflag(groupProduct, true);
			for (int i = 0; i < productDto.getQuantity(); i++ ) {
				OrderDetail orderDetail = new OrderDetail();
				
				orderDetail.setPrice(productDto.getPrice());
				orderDetail.setProduct(products.get(i));
				orderDetail.setOrder(order);
				checkoutService.orderProductNew(orderDetail);
				products.get(i).setFlag(false);
				productService.update(products.get(i));
				
//				goi mail cho admin thong bao dat hang
				StringBuilder message = new StringBuilder();
				message.append("Xin chào bạn "+ user.getFirstname()+ " " + user.getFirstname()+". \n");
				message.append("\n");
				message.append("Cảm ơn bạn đã quan tâm đến cửa hàng của chúng tôi. \n");
				message.append("Chúng tôi sẽ giải quyết đơn hàng của bạn và giao đến ban sớm nhất. \n");
				message.append("\n");
				message.append("\n");
				message.append("\n");
				message.append("------------------------------------------\n");
				message.append("\n");
				message.append("\n");
				message.append("Minimalism Shop xin chân thành cảm ơn");
				userService.sendMail(user, message.toString());
			}
			
			//kiểm tra sản phẩm còn không nếu không bật cờ 
			int countCheckStock = productService.countProductbyGroupProductandflag(groupProduct, true);
			if(countCheckStock <= 0){
				groupProduct.setEndProduct(false);
				groupProductService.update(groupProduct);
			}
			session.removeAttribute("cart");
			session.removeAttribute("viewCart");
			
		}
		return "redirect:/home";
	}
	
	
	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public String cart() {		
		return "common/cart";
	}

}
