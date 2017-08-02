package com.minimalism.shop.cmn.repository.impl;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.minimalism.shop.cmn.base.Common;
import com.minimalism.shop.cmn.repository.CheckoutRepository;
import com.minimalism.shop.entities.Order;
import com.minimalism.shop.entities.OrderDetail;

@Repository
public class CheckoutRepositoryImpl implements CheckoutRepository {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Order orderInforNew(Order order) {
		// TODO Auto-generated method stub
		if(Common.checkNullandBlank(order)){
			return null;
		}
		Session session = sessionFactory.openSession();
		Date date = new Date();
		order.setOrderDate(date);
		session.save(order);
		session.close();
		return order;
	}

	@Override
	public OrderDetail orderProductNew(OrderDetail detail) {
		// TODO Auto-generated method stub
		if(Common.checkNullandBlank(detail)){
			return null;
		}
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(detail);
		session.getTransaction().commit();
		session.close();
		
		return detail;
	}

}
