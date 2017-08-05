package com.minimalism.shop.cmn.repository;

import java.util.Date;
import java.util.List;

import com.minimalism.shop.entities.Order;
import com.minimalism.shop.entities.OrderDetail;

public interface CheckinRepository {
	public List<Order> findOrderbyStatusDay(boolean status, Date date);
	public void updateOrder(Order order);
	public List<OrderDetail> findOrderDeatil(Order order);
	public void updateOrderDetail(OrderDetail detail);
	public List<Order> findOrderbyDate(Date date);
	public List<Order> findAllListOrder();
	public List<OrderDetail> findAllListOrderDetail();

}
