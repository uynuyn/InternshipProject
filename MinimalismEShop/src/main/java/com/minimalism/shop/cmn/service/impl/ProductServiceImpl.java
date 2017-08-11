package com.minimalism.shop.cmn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minimalism.shop.cmn.base.BaseServiceImpl;
import com.minimalism.shop.cmn.repository.impl.ProductRepositoryImpl;
import com.minimalism.shop.cmn.service.ProductService;
import com.minimalism.shop.entities.GroupProduct;
import com.minimalism.shop.entities.Product;

@Service
public class ProductServiceImpl extends BaseServiceImpl<Product, Integer> implements ProductService{

	@Autowired private ProductRepositoryImpl productRepository;
	
	@Override
	public Integer countProductbyGroupProduct(GroupProduct groupProduct) {
		// TODO Auto-generated method stub
		Long count = productRepository.countProductbyGroupProduct(groupProduct);
		if(count == null){return 0;}
		return count.intValue();
	}

	@Override
	public Integer countProductbyGroupProductandflag(GroupProduct groupProduct, boolean flag) {
		// TODO Auto-generated method stub
		Long count = productRepository.countProductbyGroupProductandflag(groupProduct, flag);
		if(count == null){return 0;}
 		return count.intValue();
	}

	@Override
	public List<Product> findProductbyGroupProduct(GroupProduct groupProduct) {
		// TODO Auto-generated method stub
		return productRepository.findProductbyGroupProduct(groupProduct);
	}

	@Override
	public List<Product> findProductbyGroupProductandflag(Integer idGroupProduct, boolean flag) {
		// TODO Auto-generated method stub
		return productRepository.findProductbyGroupProductandflag(idGroupProduct, flag);
	}


}
