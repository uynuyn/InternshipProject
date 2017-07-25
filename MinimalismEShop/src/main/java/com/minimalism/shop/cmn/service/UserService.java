package com.minimalism.shop.cmn.service;

import com.minimalism.shop.entities.User;

public interface UserService {
	public User findUserbyUsername(String username, String email);
	public User save(User user);
	public boolean loginUser(User user);

}
