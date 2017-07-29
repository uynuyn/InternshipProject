package com.minimalism.shop.cmn.service;

import java.util.List;

import com.minimalism.shop.entities.GroupProduct;

public interface GroupProductService {
	public List<GroupProduct> findAllList();

	public GroupProduct findProductbyName(String name);

	public GroupProduct findProductbyId(int id);

	public GroupProduct findProductbyCategory(String category);

	public List<GroupProduct> findListProductbyCode(String categoryCode);
	
	public List<GroupProduct> findListProductTop();

}
