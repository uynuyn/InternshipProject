package com.minimalism.shop.cmn.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minimalism.shop.cmn.base.BaseServiceImpl;
import com.minimalism.shop.cmn.repository.impl.GroupProductRepositoryImpl;
import com.minimalism.shop.cmn.service.GroupProductService;
import com.minimalism.shop.entities.GroupProduct;

@Service
public class GroupProductServiceImpl extends BaseServiceImpl<GroupProduct, Integer> implements GroupProductService {

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
	public GroupProduct findProductbyId(int id) {
		// TODO Auto-generated method stub
		return groupProductRepository.findProductbyId(id);
	}

	@Override
	public List<GroupProduct> findListProductTop(Date date) {
		// TODO Auto-generated method stub
		return groupProductRepository.findListProductTop(date);
	}

	@Override
	public List<GroupProduct> findProductbyCategory(Integer category) {
		// TODO Auto-generated method stub
		return groupProductRepository.findProductbyCategory(category);
	}

	@Override
	public List<GroupProduct> searchProduct(String name) {
		// TODO Auto-generated method stub
		return groupProductRepository.searchProduct(name);
	}

	@Override
	public List<GroupProduct> findrRelatedProduct(GroupProduct groupProduct) {
		// TODO Auto-generated method stub
		return groupProductRepository.findrRelatedProduct(groupProduct);
	}
	
	@Override
	public List<GroupProduct> findHabitProduct(List<String> list) {
		// TODO Auto-generated method stub
		return groupProductRepository.findHabitProduct(list);
	}
	
}
