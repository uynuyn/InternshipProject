package com.minimalism.shop.cmn.repository.impl;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.minimalism.shop.cmn.base.Common;
import com.minimalism.shop.cmn.repository.UserRepository;
import com.minimalism.shop.entities.User;

@Repository
public class UserRepositoryImpl implements UserRepository{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public User findUserbyUsername(String username, String email) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("select user from User user where user.username = :username and user.email = :email");
		query.setParameter("username", username);
		query.setParameter("email", email);
		User user =  (User) query.uniqueResult();
		session.close();
		return user;
	}

	@Override
	public User save(User user) {
		if(Common.checkNullandBlank(user)){
			return null;
		}
		Session session = sessionFactory.openSession();
		session.save(user);
		session.close();
		return user;
	}

	@Override
	public boolean loginUser(User user) {
		// TODO Auto-generated method stub
		if(Common.checkNullandBlank(user)){
			return false;
		}
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(User.class)
				.add(Restrictions.eq("username", user.getUsername()));
		User users = (User) criteria.uniqueResult();
		if(!Common.checkNullandBlank(users)){
			user.setPassword(Common.passEncode(user.getPassword(), users.getSalt()));
			if(user.getPassword().equals(users.getPassword())){
				return true;
			}
		}
		
		return false;
	}

}
