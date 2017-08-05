package com.minimalism.shop.cmn.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.minimalism.shop.cmn.base.BaseRepositoryImpl;
import com.minimalism.shop.cmn.base.Common;
import com.minimalism.shop.cmn.repository.ProductRepository;
import com.minimalism.shop.entities.GroupProduct;
import com.minimalism.shop.entities.Product;

@Repository
public class ProductRepositoryImpl extends BaseRepositoryImpl<Product, Integer> implements ProductRepository {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Long countProductbyGroupProduct(GroupProduct groupProduct) {
		// TODO Auto-generated method stub
		if (Common.checkNullandBlank(groupProduct)) {
			return null;
		}
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Product.class)
				.add(Restrictions.eq("groupProduct.id", groupProduct.getId()))
				.setProjection(Projections.rowCount());
		Long count = (Long) criteria.uniqueResult();
		session.close();
		return count;
	}

	@Override
	public Long countProductbyGroupProductandflag(GroupProduct groupProduct, boolean flag) {
		// TODO Auto-generated method stub
		if (Common.checkNullandBlank(groupProduct)) {
			return null;
		}
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Product.class)
				.add(Restrictions.eq("groupProduct.id", groupProduct.getId()))
				.add(Restrictions.eq("flag", flag))
				.setProjection(Projections.rowCount());
		Long count = (Long) criteria.uniqueResult();
		session.close();
		return count;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findProductbyGroupProduct(GroupProduct groupProduct) {
		// TODO Auto-generated method stub
		if(Common.checkNullandBlank(groupProduct)){
			return null;
		}
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Product.class)
				.add(Restrictions.eq("groupProduct", groupProduct));
		List<Product> products = criteria.list();
		session.close();
		return products;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findProductbyGroupProductandflag(GroupProduct groupProduct, boolean flag) {
		// TODO Auto-generated method stub
		if(Common.checkNullandBlank(groupProduct)){
			return null;
		}
		Session session = sessionFactory.openSession();
		Criteria criteria= session.createCriteria(Product.class)
				.add(Restrictions.eq("groupProduct", groupProduct))
				.add(Restrictions.eq("flag", flag));
		List<Product> products = criteria.list();
		session.close();
		return products;
	}

}
