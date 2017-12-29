package com.minimalism.shop.cmn.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.minimalism.shop.cmn.base.BaseRepositoryImpl;
import com.minimalism.shop.cmn.repository.AprioriRepository;
import com.minimalism.shop.entities.Involve;

@Repository
public class AprioriRepositoryImpl extends BaseRepositoryImpl<Involve, Integer> implements AprioriRepository{

	@Autowired private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Involve> findAllList() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Involve.class);
		List<Involve> involves = criteria.list();
		for (Involve involve : involves) {
			Hibernate.initialize(involve.getGroupProduct());
		}
		session.close();
		return involves;
	}
}
