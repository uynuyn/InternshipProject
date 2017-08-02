package com.minimalism.shop.cmn.repository;

import java.util.List;

import com.minimalism.shop.entities.GroupProduct;

public interface GroupProductRepository {
	public List<GroupProduct> findAllList();
	
	public GroupProduct findProductbyName(String name);
	
	public GroupProduct findProductbyId(int id);

	public GroupProduct findProductbyCategory(String category);
	
	public List<GroupProduct> findListProductbyCode(String categoryCode);
	
	public List<GroupProduct> findListProductTop();
	
	public boolean updateGroupProduct(GroupProduct groupProduct);
}
