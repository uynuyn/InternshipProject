package com.minimalism.shop.cmn.service;

import java.util.List;

import com.minimalism.shop.entities.GroupProduct;

public interface GroupProductService {
	public List<GroupProduct> findAllList();

	public GroupProduct findProductbyId(int id);

	public List<GroupProduct> findProductbyCategory(Integer category);

	public List<GroupProduct> findListProductbyCode(String categoryCode);
	
	public List<GroupProduct> findListProductTop();
	
}
