package com.minimalism.shop.cmn.service;

import java.util.List;

import com.minimalism.shop.entities.Category;

public interface CategoryService {
	public List<Category> findAllList();
	public Category findCategorybyId(int id);
	public Category findCategorybyName(String name);
	public Category findProductbyCodeofCategory(String code);
	public List<Category> findCategoryDepartment(int department);

}
