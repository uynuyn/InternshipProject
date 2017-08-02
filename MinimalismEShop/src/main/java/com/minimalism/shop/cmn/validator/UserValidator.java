package com.minimalism.shop.cmn.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.minimalism.shop.entities.User;

@Component
public class UserValidator implements Validator{
	
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		User user = (User) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty.user.username");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.user.password");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "NotEmpty.user.phone");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.user.email");
        
        if(user.getPhone()!=null){
        	if(user.getPhone().length()>12 || user.getPhone().length()<9){
        		errors.rejectValue("phone", "NotEmpty.user.error.phone");
        	}        	
        	if(user.getPassword().length()<6){
        		errors.rejectValue("password", "NotEmpty.user.error.password");
        	}
        }
		
	}

}
