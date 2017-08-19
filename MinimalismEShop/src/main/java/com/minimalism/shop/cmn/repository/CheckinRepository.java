package com.minimalism.shop.cmn.repository;

import java.util.Date;
import java.util.List;

import com.minimalism.shop.entities.Order;
import com.minimalism.shop.entities.OrderDetail;

public interface CheckinRepository {
	public List<Order> findOrderbyStatusDay(boolean status, Date date);
	public List<OrderDetail> findOrderDeatil(Order order);
	public void updateOrderDetail(OrderDetail detail);
	public List<Order> findOrderbyDate(Date date, boolean status);
	public List<Order> findAllListOrder();
	public List<OrderDetail> findAllListOrderDetail();
	public Order findOrderbyId(int id);
	public List<OrderDetail> findOrderDetailbyOrder(Order order);

}
