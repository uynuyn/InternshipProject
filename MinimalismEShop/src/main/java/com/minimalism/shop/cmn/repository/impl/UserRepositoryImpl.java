package com.minimalism.shop.cmn.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.minimalism.shop.cmn.base.BaseRepositoryImpl;
import com.minimalism.shop.cmn.base.Common;
import com.minimalism.shop.cmn.repository.UserRepository;
import com.minimalism.shop.entities.User;

@SuppressWarnings("unchecked")
@Repository
public class UserRepositoryImpl extends BaseRepositoryImpl<User, Integer> implements UserRepository {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean findUserbyUsernameEmail(String username, String email) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(User.class)
				.add(Restrictions.or(Restrictions.eq("username", username), Restrictions.eq("email", email)));
		List<User> user = criteria.list();
		System.out.println(user.size());
		session.close();
		if (user.size() > 0) {
			return true;
		}
		return false;
	}

	/*
	 * @Override public User save(User user) {
	 * if(Common.checkNullandBlank(user)){ return null; } Session session =
	 * sessionFactory.openSession(); session.save(user); session.close(); return
	 * user; }
	 */

	@Override
	public User loginUser(User user) {
		// TODO Auto-generated method stub
		if (Common.checkNullandBlank(user)) {
			return new User();
		}
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(User.class).add(Restrictions.eq("username", user.getUsername()));
		User users = (User) criteria.uniqueResult();
		if (!Common.checkNullandBlank(users)) {
			// user.setPassword(Common.passEncode(user.getPassword(),
			// users.getSalt()));
			if (user.getPassword().equals(users.getPassword())) {
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
		Criteria criteria = session.createCriteria(User.class).add(Restrictions.eq("username", username));
		User auser = (User) criteria.uniqueResult();
		session.close();
		return auser;
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteInBatch(Iterable<User> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll(Sort arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll(Iterable<Integer> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends User> List<S> findAll(Example<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends User> List<S> findAll(Example<S> arg0, Sort arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getOne(Integer arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends User> List<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends User> S saveAndFlush(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<User> findAll(Pageable arg0) {
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
	public void delete(Iterable<? extends User> arg0) {
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
	public User findOne(Integer arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends User> long count(Example<S> arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends User> boolean exists(Example<S> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends User> Page<S> findAll(Example<S> arg0, Pageable arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends User> S findOne(Example<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
