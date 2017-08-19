package com.minimalism.shop.cmn.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.minimalism.shop.cmn.base.BaseRepositoryImpl;
import com.minimalism.shop.cmn.repository.PermissionReposity;
import com.minimalism.shop.entities.Permission;
import com.minimalism.shop.entities.User;

@Repository
public class PermissionRepositoryImpl extends BaseRepositoryImpl<Permission, Integer> implements PermissionReposity {

	@Autowired private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Permission> findRolebyUser(User user) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Permission.class);
		criteria.add(Restrictions.eq("user.id", user.getId()));
		List<Permission> permissions = criteria.list();
		for (Permission permission : permissions) {
			Hibernate.initialize(permission.getUser());
			Hibernate.initialize(permission.getRole());
		}
		session.close();
		return permissions;
	}
	

}
