package com.minimalism.shop.cmn.repository;

import java.util.List;

import com.minimalism.shop.entities.Category;

public interface CategoryRepository {
	public List<Category> findAllList();
	public Category findCategorybyId(int id);
	public Category findCategorybyName(String name);	
	public Category findProductbyCodeofCategory(String code);

}
