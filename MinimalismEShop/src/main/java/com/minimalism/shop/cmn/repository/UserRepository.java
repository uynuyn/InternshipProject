package com.minimalism.shop.cmn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minimalism.shop.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	public boolean findUserbyUsernameEmail(String username, String email);
//	public User save(User user);
	public User loginUser(User user);
	public User updateUser(User user);
	public User findUserbyUsername(String username);

}
