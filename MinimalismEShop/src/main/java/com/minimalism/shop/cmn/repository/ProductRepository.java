package com.minimalism.shop.cmn.repository;

import java.util.List;

import com.minimalism.shop.entities.GroupProduct;
import com.minimalism.shop.entities.Product;

public interface ProductRepository {
	public Long countProductbyGroupProduct(GroupProduct groupProduct);
	
	public Long countProductbyGroupProductandflag(GroupProduct groupProduct, boolean flag);
	
	public List<Product> findProductbyGroupProduct(GroupProduct groupProduct);
	
	public List<Product> findProductbyGroupProductandflag(GroupProduct groupProduct, boolean flag);
	
	public boolean updateProduct(Product product);

}