package com.minimalism.shop.controller.admin;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.minimalism.shop.cmn.service.impl.CheckinServiceImpl;
import com.minimalism.shop.cmn.service.impl.UserServiceImpl;
import com.minimalism.shop.dto.OrderProduct;
import com.minimalism.shop.entities.Order;

@Controller
@RequestMapping("/delivery")
public class DeliveryController {
	@Autowired private CheckinServiceImpl checkinService;
	@Autowired private UserServiceImpl userService;


	@RequestMapping(value = "/list-order", method = RequestMethod.GET)
	public String listOrder(Model model, HttpServletRequest request) {
		String date = request.getParameter("dateOrder");
		List<Order> listOrder = new ArrayList<>();
		if(date==null || date.equals("")){
			// ngày less equals hiện tại
			listOrder = checkinService.findOrderbyStatusDay(true);
		}else {
			Date date2 = null;
			try {
				date2 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
				listOrder = checkinService.findOrderbyDate(date2,true);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		model.addAttribute("delivery", "delivery");
		model.addAttribute("listOrder", listOrder);
		return "list-order";
	}
	
	@RequestMapping(value = "/view-product-order/{id}", method = RequestMethod.GET)
	public String vieworder(Model model,HttpSession session, @PathVariable("id") int id) {		
		OrderProduct orderProduct = checkinService.findOrderbyIdView(id);
		
		model.addAttribute("order", orderProduct);
		return "view-product-order";
	}
	
	@RequestMapping(value = "/view-product-order/{id}", method = RequestMethod.POST)
	public String vieworder(Model model, @PathVariable("id") int id) {
		Order order = checkinService.findOrderbyId(id);
		order.setDelivery(true);
		Date date = new Date();
		order.setDeliveryDate(date);
		checkinService.update(order);
//		goi mail cho khách hàng thong bao da chuyen hang
		StringBuilder message = new StringBuilder();
		message.append("Xin chào bạn "+ order.getUser().getFirstname()+ " " + order.getUser().getFirstname()+". \n");
		message.append("\n");
		message.append("Giao hàng thành công . \n");
		message.append("\n");
		message.append("Đơn hàng đã giao thành công \n");
		message.append("\n");
		message.append("------------------------------------------\n");
		message.append("\n");
		message.append("\n");
		message.append("\n");
		message.append("Minimalism Shop xin chân thành cảm ơn");
		userService.sendMail(order.getUser().getEmail(), message.toString());
		model.addAttribute("notification", "delivery");
		
		return "redirect:/delivery/list-order";			
		
	}

}
