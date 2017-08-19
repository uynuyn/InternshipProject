package com.minimalism.shop.cmn.service;

import java.util.Date;
import java.util.List;

import com.minimalism.shop.dto.OrderProduct;
import com.minimalism.shop.entities.Order;
import com.minimalism.shop.entities.OrderDetail;

public interface CheckinService {
	public List<Order> findOrderbyStatusDay(boolean status);
	public List<OrderDetail> findOrderDeatil(Order order);
	public boolean updateOrderDetail(OrderDetail detail);
	public List<Order> findOrderbyDate(Date date,boolean status);
	public List<Order> findAllListOrder();
	public List<OrderDetail> findAllListOrderDetail();
	public OrderProduct findOrderbyIdView(int id);
	public Order findOrderbyId(int id);
	public List<OrderDetail> findOrderDetailbyOrder(Order order);



}
