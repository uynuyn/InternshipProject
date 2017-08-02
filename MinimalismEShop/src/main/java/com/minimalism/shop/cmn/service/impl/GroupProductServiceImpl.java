package com.minimalism.shop.cmn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minimalism.shop.cmn.repository.impl.GroupProductRepositoryImpl;
import com.minimalism.shop.cmn.service.GroupProductService;
import com.minimalism.shop.entities.GroupProduct;

@Service
public class GroupProductServiceImpl implements GroupProductService {

	@Autowired
	private GroupProductRepositoryImpl groupProductRepository;

	@Override
	public List<GroupProduct> findAllList() {
		return groupProductRepository.findAllList();
	}

	@Override
	public List<GroupProduct> findListProductbyCode(String categoryCode) {
		// TODO Auto-generated method stub
		return groupProductRepository.findListProductbyCode(categoryCode);
	}

	@Override
	public GroupProduct findProductbyName(String name) {
		// TODO Auto-generated method stub
		return groupProductRepository.findProductbyName(name);
	}

	@Override
	public GroupProduct findProductbyId(int id) {
		// TODO Auto-generated method stub
		return groupProductRepository.findProductbyId(id);
	}

	@Override
	public GroupProduct findProductbyCategory(String category) {
		// TODO Auto-generated method stub
		return groupProductRepository.findProductbyCategory(category);
	}

	@Override
	public List<GroupProduct> findListProductTop() {
		// TODO Auto-generated method stub
		return groupProductRepository.findListProductTop();
	}

	@Override
	public boolean updateGroupProduct(GroupProduct groupProduct) {
		// TODO Auto-generated method stub
		return groupProductRepository.updateGroupProduct(groupProduct);
	}
	
}
