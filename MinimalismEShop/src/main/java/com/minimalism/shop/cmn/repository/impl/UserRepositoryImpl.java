package com.minimalism.shop.cmn.repository.impl;

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
import com.minimalism.shop.cmn.base.Common;
import com.minimalism.shop.cmn.repository.UserRepository;
import com.minimalism.shop.entities.User;

@Repository
public class UserRepositoryImpl extends BaseRepositoryImpl<User, Integer> implements UserRepository{

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean findUserbyUsernameEmail(String username, String email) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(User.class)
				.add(Restrictions.or(Restrictions.eq("username", username),Restrictions.eq("email", email)));
		List<User> user =  criteria.list();
		System.out.println(user.size());
		session.close();
		if(user.size()>0){
			return true;
		}
		return false;
	}

	/*@Override
	public User save(User user) {
		if(Common.checkNullandBlank(user)){
			return null;
		}
		Session session = sessionFactory.openSession();
		session.save(user);
		session.close();
		return user;
	}*/

	@Override
	public User loginUser(User user) {
		// TODO Auto-generated method stub
		if(Common.checkNullandBlank(user)){
			return new User();
		}
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(User.class)
				.add(Restrictions.eq("username", user.getUsername()));
		User users = (User) criteria.uniqueResult();
		if(!Common.checkNullandBlank(users)){
			//user.setPassword(Common.passEncode(user.getPassword(), users.getSalt()));
			if(user.getPassword().equals(users.getPassword())){
				return users;
			}
		}
		
		return null;
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.update(user);
			tx.commit();
			return user;
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public User findUserbyUsername(String username) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(User.class)
				.add(Restrictions.eq("username", username));
		User auser = (User) criteria.uniqueResult();
		for(int i = 0 ; i < auser.getPermissions().size(); i++){
			Hibernate.initialize(auser.getPermissions().get(i).getRole());
		}
		session.close();
		return auser;
	}

}
