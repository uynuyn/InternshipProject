package com.minimalism.shop.cmn.repository;

import java.util.List;

import com.minimalism.shop.entities.Permission;
import com.minimalism.shop.entities.User;

public interface PermissionReposity {

	public List<Permission> findRolebyUser(User user);
}
