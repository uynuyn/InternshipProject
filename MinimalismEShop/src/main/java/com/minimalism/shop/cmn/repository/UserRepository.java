package com.minimalism.shop.cmn.repository;

import com.minimalism.shop.entities.User;

public interface UserRepository {
	public boolean findUserbyUsernameEmail(String username, String email);
//	public User save(User user);
	public User loginUser(User user);
	public User updateUser(User user);
	public User findUserbyUsername(String username);

}
