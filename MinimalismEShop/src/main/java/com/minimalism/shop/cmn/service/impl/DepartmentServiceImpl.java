package com.minimalism.shop.cmn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minimalism.shop.cmn.repository.impl.DepartmentRepositoryImpl;
import com.minimalism.shop.cmn.service.DepartmentService;
import com.minimalism.shop.entities.Department;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepositoryImpl departmentRepository;

	@Override
	public List<Department> findAllList() {
		// TODO Auto-generated method stubS
		return departmentRepository.findAllList();
	}

	@Override
	public Department findProductbyCode(String code) {
		// TODO Auto-generated method stub
		return departmentRepository.findProductbyCode(code);
	}

}
