package com.minimalism.shop.cmn.repository;

import java.util.Date;
import java.util.List;

import com.minimalism.shop.entities.GroupProduct;

public interface GroupProductRepository {
	public List<GroupProduct> findAllList();
		
	public GroupProduct findProductbyId(int id);

	public List<GroupProduct> findProductbyCategory(Integer category);
	
	public List<GroupProduct> findListProductbyCode(String categoryCode);
	
	public List<GroupProduct> findListProductTop(Date date);	
	
	public List<GroupProduct> searchProduct(String name);
	
	public List<GroupProduct> findrRelatedProduct(GroupProduct groupProduct);
	
	public List<GroupProduct> findHabitProduct(List<String> list);
}
