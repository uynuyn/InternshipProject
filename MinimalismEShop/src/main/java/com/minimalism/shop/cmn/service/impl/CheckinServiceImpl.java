package com.minimalism.shop.cmn.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minimalism.shop.cmn.base.BaseServiceImpl;
import com.minimalism.shop.cmn.repository.impl.CheckinRepositoryImpl;
import com.minimalism.shop.cmn.service.CheckinService;
import com.minimalism.shop.dto.OrderProduct;
import com.minimalism.shop.dto.ProductDto;
import com.minimalism.shop.entities.Order;
import com.minimalism.shop.entities.OrderDetail;

@Service
public class CheckinServiceImpl extends BaseServiceImpl<Order, Integer> implements CheckinService{
	
	@Autowired private CheckinRepositoryImpl checkinRepository;

	@Override
	public List<Order> findOrderbyStatusDay(boolean status) {
		// TODO Auto-generated method stub
		Date date = new Date();
		return checkinRepository.findOrderbyStatusDay(status, date);
	}

	@Override
	public List<OrderDetail> findOrderDeatil(Order order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateOrderDetail(OrderDetail detail) {
		// TODO Auto-generated method stub
		try {
			checkinRepository.updateOrderDetail(detail);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public List<Order> findOrderbyDate(Date date, boolean status) {
		// TODO Auto-generated method stub
		return checkinRepository.findOrderbyDate(date,status);
	}

	@Override
	public List<Order> findAllListOrder() {
		// TODO Auto-generated method stub
		return checkinRepository.findAllListOrder();
	}

	@Override
	public List<OrderDetail> findAllListOrderDetail() {
		// TODO Auto-generated method stub
		return checkinRepository.findAllListOrderDetail();
	}

	@Override
	public OrderProduct findOrderbyIdView(int id) {
		// TODO Auto-generated method stub
		Order order = checkinRepository.findOrderbyId(id);
		OrderProduct orderProduct = new OrderProduct();
		List<ProductDto> listProductDto = new ArrayList<>();
		orderProduct.setId(order.getId());
		orderProduct.setName(order.getUser().getEmail());
		orderProduct.setPhone(order.getUser().getPhone());
		orderProduct.setDelivery(order.getStatus());
		orderProduct.setAddress(order.getAddress());
		orderProduct.setDate(order.getOrderDate());
		Double subtotal=0.0;
		int qty =0;
		boolean flag = true;
		int flagcount = 0;
		List<OrderDetail> details = checkinRepository.findOrderDetailbyOrder(order);
		int total = 0;
		for(int j = 0 ; j < details.size(); j++ ){
			ProductDto productDto = new ProductDto();
			productDto.setCategory(details.get(j).getProduct().getGroupProduct().getCategory().getName());
			productDto.setName(details.get(j).getProduct().getGroupProduct().getName());
			subtotal+= details.get(j).getPrice();
			
			
			if(j>=1 && details.get(j).getProduct().getGroupProduct().getId().equals(details.get(j-1).getProduct().getGroupProduct().getId())){
				total += details.get(j).getPrice();
				qty+= 1;
				flagcount++;
				flag = false;
			}
			
			if(flag){
				qty =1;
				total = details.get(j).getPrice();
				productDto.setQuantity(qty);
				productDto.setPrice(total);
				listProductDto.add(productDto);
			}
			else {
				productDto.setQuantity(qty);
				productDto.setPrice(total);
				listProductDto.add(productDto);
				listProductDto.remove(j-flagcount);
				flag = true;
			}
		}
		orderProduct.setLstProduct(listProductDto);
		orderProduct.setSubtotal(subtotal);
		return orderProduct;
	}

	@Override
	public List<OrderDetail> findOrderDetailbyOrder(Order order) {
		// TODO Auto-generated method stub
		return checkinRepository.findOrderDetailbyOrder(order);
	}

	@Override
	public Order findOrderbyId(int id) {
		// TODO Auto-generated method stub
		return checkinRepository.findOrderbyId(id);
	}

}
