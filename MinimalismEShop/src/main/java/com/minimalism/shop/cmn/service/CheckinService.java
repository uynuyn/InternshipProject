package com.minimalism.shop.cmn.service;

import java.util.Date;
import java.util.List;

import com.minimalism.shop.entities.Order;
import com.minimalism.shop.entities.OrderDetail;

public interface CheckinService {
	public List<Order> findOrderbyStatusDay();
	public boolean updateOrder(Order order);
	public List<OrderDetail> findOrderDeatil(Order order);
	public boolean updateOrderDetail(OrderDetail detail);
	public List<Order> findOrderbyDate(Date date);
	public List<Order> findAllListOrder();
	public List<OrderDetail> findAllListOrderDetail();
}
