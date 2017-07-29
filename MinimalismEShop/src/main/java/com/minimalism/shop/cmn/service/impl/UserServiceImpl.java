package com.minimalism.shop.cmn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minimalism.shop.cmn.repository.impl.UserRepositoryImpl;
import com.minimalism.shop.cmn.service.UserService;
import com.minimalism.shop.entities.User;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepositoryImpl userRepository;

	@Override
	public User findUserbyUsername(String username, String email) {
		// TODO Auto-generated method stub
		return userRepository.findUserbyUsername(username, email);
	}

	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public boolean loginUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.loginUser(user);
	}

}
