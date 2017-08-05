package com.minimalism.shop.cmn.service;

import com.minimalism.shop.entities.Order;
import com.minimalism.shop.entities.OrderDetail;

public interface CheckoutService {
	public Order orderInforNew(Order order);
	public Order findOrderofUserinDate(Order order);
	public OrderDetail orderProductNew(OrderDetail detail);

}
