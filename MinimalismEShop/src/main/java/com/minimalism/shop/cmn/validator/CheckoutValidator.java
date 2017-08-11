package com.minimalism.shop.cmn.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.minimalism.shop.dto.CheckoutDto;

@Component
public class CheckoutValidator implements Validator{
// kiem tra nhap thong tin nguoi dung để cho phép dat mua hàng
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return CheckoutDto.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"username", "NotEmpty.user.username");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"email", "NotEmpty.user.email");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"phone", "NotEmpty.user.phone");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"firstname", "NotEmpty.user.firstname");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"lastname", "NotEmpty.user.lastname");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"addressStreet", "NotEmpty.user.addressStreet");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"addressSuite", "NotEmpty.user.addressSuite");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"addressCity", "NotEmpty.user.addressCity");

	}

}
