package com.minimalism.shop.cmn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minimalism.shop.cmn.base.BaseRepositoryImpl;
import com.minimalism.shop.cmn.base.BaseServiceImpl;
import com.minimalism.shop.cmn.repository.CategoryRepository;
import com.minimalism.shop.cmn.repository.impl.CategoryRepositoryImpl;
import com.minimalism.shop.cmn.service.CategoryService;
import com.minimalism.shop.entities.Category;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepositoryImpl categoryRepository;
	
	@Override
	public List<Category> findAllList() {
		// TODO Auto-generated method stub
		return categoryRepository.findAllList();
	}

	@Override
	public Category findCategorybyId(int id) {
		// TODO Auto-generated method stub
		return categoryRepository.findCategorybyId(id);
	}

	@Override
	public Category findCategorybyName(String name) {
		// TODO Auto-generated method stub
		return categoryRepository.findCategorybyName(name);
	}

	@Override
	public Category findProductbyCodeofCategory(String code) {
		// TODO Auto-generated method stub
		return categoryRepository.findProductbyCodeofCategory(code);
	}

	@Override
	public List<Category> findCategoryDepartment(int department) {
		// TODO Auto-generated method stub
		return categoryRepository.findCategoryDepartment(department);
	}
	

}
