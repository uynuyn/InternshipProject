 package com.minimalism.shop.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.minimalism.shop.cmn.base.Common;
import com.minimalism.shop.cmn.service.impl.AprioriServiceImpl;
import com.minimalism.shop.cmn.service.impl.CheckoutServiceImpl;
import com.minimalism.shop.cmn.service.impl.GroupProductServiceImpl;
import com.minimalism.shop.cmn.service.impl.ProductServiceImpl;
import com.minimalism.shop.cmn.service.impl.UserServiceImpl;
import com.minimalism.shop.cmn.validator.CheckoutValidator;
import com.minimalism.shop.dto.CheckoutDto;
import com.minimalism.shop.dto.ProductDto;
import com.minimalism.shop.entities.GroupProduct;
import com.minimalism.shop.entities.Involve;
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
	
	@Autowired private CheckoutValidator checkoutValidator;
	
	@Autowired private AprioriServiceImpl aprioriService;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(checkoutValidator);
	}
	
	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public String checkout(Model model, HttpSession session) {
		model.addAttribute("checkoutForm" , new CheckoutDto());
		List<Integer> years = new ArrayList<>();
		int year = Calendar.getInstance().get(Calendar.YEAR);
		for (int i = year-5; i>= year - 100; i--){
			years.add(i);
		}
		model.addAttribute("years", years);
		session.removeAttribute("checkout");
		return "common/checkout";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/checkout", method = RequestMethod.POST)
	public String checkoutForm(HttpServletRequest request, 
			@ModelAttribute("checkoutForm") @Validated CheckoutDto checkoutDto,
			final BindingResult result,
			Model model,HttpSession session) {
		if (result.hasErrors()) {
			return "common/checkout";
	    }
		User user = (User) session.getAttribute("users");
		user.setFirstname(checkoutDto.getFirstname());
		user.setLastname(checkoutDto.getLastname());
		user.setPhone(checkoutDto.getPhone());
		user.setAddressStreet(checkoutDto.getAddressStreet());
		user.setAddressSuite(checkoutDto.getAddressSuite());
		user.setAddressCity(checkoutDto.getAddressCity());
		user.setYears(1993);
		userService.updateUser(user);
		
		
		Order order = new Order();
		order.setUser(user);
		order.setAddress(checkoutDto.getAddressStreet() +" " + checkoutDto.getAddressSuite() + " "+ checkoutDto.getAddressCity());
		order.setStatus(false);
		order.setNote(checkoutDto.getNote());
		order.setDelivery(false);
		order = checkoutService.orderInforNew(order);
		
		Map<Integer, ProductDto> mapItem = (Map<Integer, ProductDto>) session.getAttribute("cart");
		int size = mapItem.keySet().size();
		for (ProductDto productDto : mapItem.values()) {
			GroupProduct groupProduct = groupProductService.findProductbyId(productDto.getId());
			List<Product> products = productService.findProductbyGroupProductandflag(groupProduct.getId(), true);
			for (int i = 0; i < productDto.getQuantity(); i++ ) {
				OrderDetail orderDetail = new OrderDetail();
				
				orderDetail.setPrice(productDto.getPrice());
				orderDetail.setProduct(products.get(i));
				orderDetail.setOrder(order);
				checkoutService.orderProductNew(orderDetail);
				products.get(i).setFlag(false);
				productService.update(products.get(i));
				

			}
			
////			goi mail cho khách hàng thong bao dat hang
//			StringBuilder message = new StringBuilder();
//			message.append("<p style='font-size:36px;'><img src='cid:identifier1234' width='90' height='90'> Xin chào bạn "+ user.getFirstname()+ " " + user.getFirstname()+".</p><br>");
//			message.append("<h2 style='color: #999999'>Cảm ơn bạn đã quan tâm đến cửa hàng của chúng tôi. </h2><br>");
//			message.append("<h2 style='color: #262626'>Chúng tôi sẽ giải quyết đơn hàng của bạn và giao đến ban sớm nhất. </h2><br>");
//			message.append("<hr>");
//			message.append("Minimalism Shop xin chân thành cảm ơn");
//			userService.sendMail(user.getEmail(), message.toString());
////			goi mail cho admin thong bao dat hang
//			StringBuilder messageAdmin = new StringBuilder();
//			messageAdmin.append("Hệ thống đã tiếp nhận đơn hàng của bạn "+ user.getFirstname()+ " " + user.getFirstname()+". <br>");
//			messageAdmin.append("Vui lòng vào hệ thống kiểm tra hàng. <br>");
//			messageAdmin.append("<br>");
//			messageAdmin.append("<br>");
//			messageAdmin.append("<hr>");
//			messageAdmin.append("<br>");
//			messageAdmin.append("Minimalism Shop xin chân thành cảm ơn");
//			userService.sendMail(Common.mailAdmin, messageAdmin.toString());
			
			if(size>1){
				Involve involve = new Involve();
				involve.setOrder(order);
				involve.setGroupProduct(groupProduct);
				aprioriService.save(involve);
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
