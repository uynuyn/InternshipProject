package com.minimalism.shop.cmn.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.minimalism.shop.cmn.base.BaseRepositoryImpl;
import com.minimalism.shop.cmn.repository.PermissionReposity;
import com.minimalism.shop.entities.Permission;
import com.minimalism.shop.entities.User;

@SuppressWarnings("unchecked")
@Repository
public class PermissionRepositoryImpl extends BaseRepositoryImpl<Permission, Integer> implements PermissionReposity {

	@Autowired private SessionFactory sessionFactory;
	
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

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteInBatch(Iterable<Permission> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Permission> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Permission> findAll(Sort arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Permission> findAll(Iterable<Integer> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Permission> List<S> findAll(Example<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Permission> List<S> findAll(Example<S> arg0, Sort arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Permission getOne(Integer arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Permission> List<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Permission> S saveAndFlush(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Permission> findAll(Pageable arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Integer arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends Permission> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean exists(Integer arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Permission findOne(Integer arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Permission> long count(Example<S> arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Permission> boolean exists(Example<S> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends Permission> Page<S> findAll(Example<S> arg0, Pageable arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Permission> S findOne(Example<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
