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
import com.minimalism.shop.cmn.repository.DepartmentRepository;
import com.minimalism.shop.entities.Category;
import com.minimalism.shop.entities.Department;

@Repository
public class DepartmentRepositoryImpl extends BaseRepositoryImpl<Department, Integer> implements DepartmentRepository{

	@Autowired
	private SessionFactory sessionFactory;   
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Department> findAllList() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Department.class);
		List<Department> listDepartment = criteria.list();
		for (Department department : listDepartment) {
			Hibernate.initialize(department.getCategories());
			for (Category category: department.getCategories()) {
				Hibernate.initialize(category.getGroupProducts());
			}
		}
		session.close();
		return listDepartment;
	}

	@Override
	public Department findProductbyCode(String code) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Department.class)
				.add(Restrictions.eq("code", code));
		Department department = (Department) criteria.uniqueResult();
		for(int i=0 ; i < department.getCategories().size(); i++){
			Hibernate.initialize(department.getCategories().get(i).getGroupProducts());			
		}
		session.close();
		return department;
	}

}
