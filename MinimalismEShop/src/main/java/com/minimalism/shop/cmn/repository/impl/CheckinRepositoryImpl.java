package com.minimalism.shop.cmn.repository.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.minimalism.shop.cmn.base.BaseRepositoryImpl;
import com.minimalism.shop.cmn.repository.CheckinRepository;
import com.minimalism.shop.entities.Order;
import com.minimalism.shop.entities.OrderDetail;

@Repository
public class CheckinRepositoryImpl extends BaseRepositoryImpl<Order, Integer> implements CheckinRepository {

	@Autowired private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Order> findOrderbyStatusDay(boolean status, Date date) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			Criteria criteria = session.createCriteria(Order.class);
			if(!status){
				criteria.add(Restrictions.and(Restrictions.or(Restrictions.isNull("status"),Restrictions.eq("status", status)),Restrictions.eq("delivery", false)));				
			}else {
				criteria.add(Restrictions.and(Restrictions.eq("status", status),Restrictions.eq("delivery", false)));
			}
			criteria.add(Restrictions.le("orderDate", date));
			List<Order> list = criteria.list();
			for (Order order : list) {
				Hibernate.initialize(order.getUser());
			}
			return list;
		} finally {
			// TODO: handle finally clause
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderDetail> findOrderDeatil(Order order) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			Criteria criteria = session.createCriteria(OrderDetail.class)
					.add(Restrictions.eq("order.id", order.getId()))
					.add(Restrictions.or(Restrictions.eq("status", false),Restrictions.isEmpty("status")));
			return criteria.list();
			
		} finally {
			// TODO: handle finally clause
			session.close();
		}
	}

	@Override
	public void updateOrderDetail(OrderDetail detail) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.update(detail);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> findOrderbyDate(Date date, boolean status) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			Criteria criteria = session.createCriteria(Order.class);
			if(!status){
				criteria.add(Restrictions.or(Restrictions.isNull("status"),Restrictions.eq("status", status)));				
			}else {
				criteria.add(Restrictions.eq("status", status));
			}
			criteria.add(Restrictions.eq("orderDate", date));
			List<Order> list = criteria.list();
			for (Order order : list) {
				Hibernate.initialize(order.getUser());
			}
			return list;
		} finally {
			// TODO: handle finally clause
			session.close();
		}
	}

	@Override
	public Order findOrderbyId(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			Criteria criteria = session.createCriteria(Order.class)
					.add(Restrictions.idEq(id));
			Order order = (Order) criteria.uniqueResult();
			Hibernate.initialize(order.getUser());
			Hibernate.initialize(order.getOrderDetails());
			
			return order;
		} finally {
			session.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<OrderDetail> findOrderDetailbyOrder(Order order) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			Criteria criteria = session.createCriteria(OrderDetail.class)
					.add(Restrictions.eq("order.id", order.getId()));
			List<OrderDetail> detail =  criteria.list();
			for (OrderDetail orderDetail : detail) {
				Hibernate.initialize(orderDetail.getProduct().getGroupProduct().getCategory());
				Hibernate.initialize(orderDetail.getProduct().getOrderDetails());
			}
			return detail;
		} finally {
			session.close();
		}
	}
	
	@Override
	public List<Order> findAllListOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderDetail> findAllListOrderDetail() {
		// TODO Auto-generated method stub
		return null;
	}

}
