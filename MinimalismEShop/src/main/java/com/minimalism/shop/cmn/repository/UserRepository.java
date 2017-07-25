package com.minimalism.shop.cmn.repository;

import com.minimalism.shop.entities.User;

public interface UserRepository {
	public User findUserbyUsername(String username, String email);
	public User save(User user);
	public boolean loginUser(User user);

}
