package com.minimalism.shop.cmn.base;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public abstract class BaseRepositoryImpl<E,I>{

	@Autowired private SessionFactory sessionFactory;
	
	public void delete(E entity) {
		// TODO Auto-generated method stub
	}

	public E save(E entity) {
		// TODO Auto-generated method stub
		if(Common.checkNullandBlank(entity)){
			return null;
		}
		Session session = sessionFactory.openSession();
		session.save(entity);
		session.close();
		return entity;
	}

	public E update(E entity) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.update(entity);
			tx.commit();
			return entity;
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
		return null;
	}

}
