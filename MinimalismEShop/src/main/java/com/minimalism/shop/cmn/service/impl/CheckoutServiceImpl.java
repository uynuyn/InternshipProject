package com.minimalism.shop.cmn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minimalism.shop.cmn.repository.impl.CheckoutRepositoryImpl;
import com.minimalism.shop.cmn.service.CheckoutService;
import com.minimalism.shop.entities.Order;
import com.minimalism.shop.entities.OrderDetail;

@Service
public class CheckoutServiceImpl implements CheckoutService{

	@Autowired
	public CheckoutRepositoryImpl checkoutRepository;
	
	@Override
	public Order orderInforNew(Order order) {
		// TODO Auto-generated method stub
		return checkoutRepository.orderInforNew(order);
	}

	@Override
	public OrderDetail orderProductNew(OrderDetail detail) {
		// TODO Auto-generated method stub
		return checkoutRepository.orderProductNew(detail);
	}
	

}
