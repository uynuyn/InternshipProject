package com.minimalism.shop.cmn.repository;

import com.minimalism.shop.entities.Order;
import com.minimalism.shop.entities.OrderDetail;

public interface CheckoutRepository {
	public Order orderInforNew(Order order);
	public Order findOrderofUserinDate(Order order);
	public OrderDetail orderProductNew(OrderDetail detail);

}
