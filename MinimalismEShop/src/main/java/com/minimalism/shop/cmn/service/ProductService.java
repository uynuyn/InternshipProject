package com.minimalism.shop.cmn.service;

import java.util.List;

import com.minimalism.shop.entities.GroupProduct;
import com.minimalism.shop.entities.Product;

public interface ProductService {
	public Integer countProductbyGroupProduct(GroupProduct groupProduct);

	public Integer countProductbyGroupProductandflag(GroupProduct groupProduct, boolean flag);

	public List<Product> findProductbyGroupProduct(GroupProduct groupProduct);

	public List<Product> findProductbyGroupProductandflag(GroupProduct groupProduct, boolean flag);

	public boolean updateProduct(Product product);

}
