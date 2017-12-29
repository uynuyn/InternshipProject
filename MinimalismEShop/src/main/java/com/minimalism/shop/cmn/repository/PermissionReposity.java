package com.minimalism.shop.cmn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minimalism.shop.entities.Permission;
import com.minimalism.shop.entities.User;

public interface PermissionReposity extends JpaRepository<Permission, Integer>{

	public List<Permission> findRolebyUser(User user);
}
