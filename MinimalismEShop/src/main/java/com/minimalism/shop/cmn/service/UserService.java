package com.minimalism.shop.cmn.service;

import com.minimalism.shop.entities.User;

public interface UserService {
	public User findUserbyUsername(String username, String email);
	public User save(User user);
	public User loginUser(User user);
	public User updateUser(User user);
	public void sendMail(User user, String message);
	

}
