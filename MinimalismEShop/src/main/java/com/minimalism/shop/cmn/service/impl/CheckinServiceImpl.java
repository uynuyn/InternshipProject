package com.minimalism.shop.cmn.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minimalism.shop.cmn.repository.impl.CheckinRepositoryImpl;
import com.minimalism.shop.cmn.service.CheckinService;
import com.minimalism.shop.entities.Order;
import com.minimalism.shop.entities.OrderDetail;

@Service
public class CheckinServiceImpl implements CheckinService{
	
	@Autowired private CheckinRepositoryImpl checkinRepository;

	@Override
	public List<Order> findOrderbyStatusDay() {
		// TODO Auto-generated method stub
		Date date = new Date();
		return checkinRepository.findOrderbyStatusDay(true, date);
	}

	@Override
	public boolean updateOrder(Order order) {
		// TODO Auto-generated method stub
		try {
			checkinRepository.updateOrder(order);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
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
	public List<Order> findOrderbyDate(Date date) {
		// TODO Auto-generated method stub
		return checkinRepository.findOrderbyDate(date);
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

}
