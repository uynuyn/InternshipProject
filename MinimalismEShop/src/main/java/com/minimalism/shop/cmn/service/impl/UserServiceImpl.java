package com.minimalism.shop.cmn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import com.minimalism.shop.cmn.base.BaseServiceImpl;
import com.minimalism.shop.cmn.repository.impl.UserRepositoryImpl;
import com.minimalism.shop.cmn.service.UserService;
import com.minimalism.shop.entities.User;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, Integer> implements UserService{
	
	@Autowired private UserRepositoryImpl userRepository;
	
	@Autowired private JavaMailSenderImpl javaMailSender;

	@Override
	public User findUserbyUsernameEmail(String username, String email) {
		// TODO Auto-generated method stub
		return userRepository.findUserbyUsernameEmail(username, email);
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
	public void sendMail(String mail, String message) {
		// TODO Auto-generated method stub
		SimpleMailMessage messages = new SimpleMailMessage();
		messages.setSubject("Minimalism Shop");
		messages.setTo(mail);
		messages.setText(message);
		
		javaMailSender.send(messages);
	}

	@Override
	public User findUserbyUsername(String username) {
		// TODO Auto-generated method stub
		return userRepository.findUserbyUsername(username);
	}

}
