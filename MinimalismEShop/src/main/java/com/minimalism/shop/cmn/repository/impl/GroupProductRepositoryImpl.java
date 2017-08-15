package com.minimalism.shop.cmn.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.minimalism.shop.cmn.base.BaseRepositoryImpl;
import com.minimalism.shop.cmn.repository.GroupProductRepository;
import com.minimalism.shop.entities.GroupProduct;

@Repository
public class GroupProductRepositoryImpl extends BaseRepositoryImpl<GroupProduct, Integer> implements GroupProductRepository{

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<GroupProduct> findAllList() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(GroupProduct.class);
		List<GroupProduct> list = new ArrayList<>();
		list = criteria.list();
		session.close();
		return list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<GroupProduct> findListProductbyCode(String categoryCode) {
		// lỗi Query
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(GroupProduct.class).add(Restrictions.eq("category.code", categoryCode));
		List<GroupProduct> list = criteria.list();
		session.close();
		return list;
	}
	
	@Override
	public GroupProduct findProductbyId(int id) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(GroupProduct.class).add(Restrictions.eq("id", id));
		GroupProduct groupProduct = (GroupProduct) criteria.uniqueResult();
		Hibernate.initialize(groupProduct.getCategory().getDepartment());
		session.close();
		return groupProduct;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GroupProduct> findProductbyCategory(Integer category) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			Criteria criteria = session.createCriteria(GroupProduct.class)
					.add(Restrictions.eq("category.id", category));
			return criteria.list();
			
		} finally {
			// TODO: handle finally clause
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GroupProduct> findListProductTop() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(GroupProduct.class).add(Restrictions.eq("endProduct", true)).setFirstResult(0).setMaxResults(9);
		List<GroupProduct> list = criteria.list();
		session.close();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GroupProduct> searchProduct(String name) {
		Session session = sessionFactory.openSession();
		Criteria criteria =  session.createCriteria(GroupProduct.class);
		criteria.add(Restrictions.like("code", "%"+name+"%"));
		List<GroupProduct> groupProducts = criteria.list();
		session.close();
		
		return groupProducts;
	}
}
