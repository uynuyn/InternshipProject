package com.minimalism.shop.cmn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minimalism.shop.cmn.repository.impl.PermissionRepositoryImpl;
import com.minimalism.shop.cmn.service.PermissionService;
import com.minimalism.shop.entities.Permission;
import com.minimalism.shop.entities.User;

@Service
public class PermissionServiceImpl implements PermissionService{

	@Autowired private PermissionRepositoryImpl permissionRepository;
	
	@Override
	public List<Permission> findRolebyUser(User user) {
		// TODO Auto-generated method stub
		return permissionRepository.findRolebyUser(user);
	}

}
