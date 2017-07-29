package com.minimalism.shop.cmn.service;

import java.util.List;

import com.minimalism.shop.entities.Department;

public interface DepartmentService {
	public List<Department> findAllList();

	public Department findProductbyCode(String code);
}
