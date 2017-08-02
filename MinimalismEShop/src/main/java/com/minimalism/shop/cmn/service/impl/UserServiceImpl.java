package com.minimalism.shop.cmn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import com.minimalism.shop.cmn.repository.impl.UserRepositoryImpl;
import com.minimalism.shop.cmn.service.UserService;
import com.minimalism.shop.entities.User;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired private UserRepositoryImpl userRepository;
	
	@Autowired private JavaMailSenderImpl javaMailSender;

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
	public User loginUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.loginUser(user);
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.updateUser(user);
	}

	@Override
	public void sendMail(User user, String message) {
		// TODO Auto-generated method stub
		SimpleMailMessage messages = new SimpleMailMessage();
		messages.setTo(user.getEmail());
		messages.setText(message);
		
		javaMailSender.send(messages);
	}

}
