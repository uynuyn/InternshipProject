package com.minimalism.shop.cmn.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.minimalism.shop.cmn.base.Common;
import com.minimalism.shop.cmn.repository.CategoryRepository;
import com.minimalism.shop.entities.Category;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository{
	
	@Autowired
	private SessionFactory SessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> findAllList() {
		Session session = SessionFactory.openSession();
		Criteria criteria = session.createCriteria(Category.class);
		List<Category> list = criteria.list();
		session.close();
		if(Common.checkListNullandBlank(list)){
			return null;
		}
		return list;
	}

	@Override
	public Category findCategorybyId(int id) {
		Session session = SessionFactory.openSession();
		Criteria criteria = session.createCriteria(Category.class).add(Restrictions.eq("id", id));
		Category category = (Category) criteria.uniqueResult();
		session.close();
		if(Common.checkNullandBlank(category)){
			return null;
		}
		return category;
	}

	@Override
	public Category findCategorybyName(String name) {
		Session session = SessionFactory.openSession();
		Criteria criteria = session.createCriteria(Category.class).add(Restrictions.eq("name", name));
		Category category = (Category) criteria.uniqueResult();
		session.close();
		if(Common.checkNullandBlank(category)){
			return null;
		}
		return category;
	}

	@Override
	public Category findProductbyCodeofCategory(String code) {
		Session session = SessionFactory.openSession();
		Criteria criteria = session.createCriteria(Category.class).add(Restrictions.eq("code", code));
		Category category = (Category) criteria.uniqueResult();
		if(!Common.checkNullandBlank(category)){
			Hibernate.initialize(category.getGroupProducts());
			Hibernate.initialize(category.getDepartment());
		}
		session.close();
		return category;
	}

}
