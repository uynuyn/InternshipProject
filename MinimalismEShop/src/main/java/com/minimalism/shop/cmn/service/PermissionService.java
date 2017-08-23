package com.minimalism.shop.cmn.service;

import java.util.List;

import com.minimalism.shop.entities.Permission;
import com.minimalism.shop.entities.User;

public interface PermissionService {
	public List<Permission> findRolebyUser(User user);

}
