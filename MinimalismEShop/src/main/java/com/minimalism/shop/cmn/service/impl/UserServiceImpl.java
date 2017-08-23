package com.minimalism.shop.cmn.service.impl;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.minimalism.shop.cmn.base.BaseServiceImpl;
import com.minimalism.shop.cmn.repository.impl.UserRepositoryImpl;
import com.minimalism.shop.cmn.service.UserService;
import com.minimalism.shop.entities.User;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, Integer> implements UserService {

	@Autowired
	private UserRepositoryImpl userRepository;

	@Autowired
	private JavaMailSenderImpl javaMailSender;

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
	
		try {
			MimeMessage messages = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(messages, true);
			helper.setSubject("Minimalism Shop");
			helper.setTo(mail);
			helper.setText(message, true);
			helper.addInline("identifier1234", new File("C:/Users/thucu/Desktop/Working/InternshipProject/logoSky.png"));

			javaMailSender.send(messages);
		
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public User findUserbyUsername(String username) {
		// TODO Auto-generated method stub
		return userRepository.findUserbyUsername(username);
	}

}
