package com.minimalism.shop.cmn.repository.impl;

import java.util.Calendar;
import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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
		if (Common.checkNullandBlank(order)) {
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
		if (Common.checkNullandBlank(detail)) {
			return null;
		}
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(detail);
		session.getTransaction().commit();
		session.close();

		return detail;
	}

	@Override
	public Order findOrderofUserinDate(Order order) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.DATE, 0);
			calendar.add(Calendar.MONTH, 0);
			calendar.add(Calendar.YEAR, 0);
			
			Criteria criteria = session.createCriteria(Order.class)
					.add(Restrictions.eq("user.id", order.getUser().getId())).add(Restrictions.eq("orderDate", calendar.getTime()));
			return (Order) criteria.uniqueResult();
		}finally {
			// TODO: handle finally clause
			session.close();
		}
	}

}
