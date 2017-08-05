package com.minimalism.shop.cmn.repository;

import java.util.List;

import com.minimalism.shop.entities.Department;

public interface DepartmentRepository {
	public List<Department> findAllList();
	public Department findProductbyCode(String code);

}
