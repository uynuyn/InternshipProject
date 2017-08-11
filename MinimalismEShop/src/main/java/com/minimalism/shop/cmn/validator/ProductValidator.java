package com.minimalism.shop.cmn.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.minimalism.shop.dto.AddGroupProductDto;

@Component
public class ProductValidator implements Validator{
	
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return AddGroupProductDto.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		AddGroupProductDto addGroupProductDto = (AddGroupProductDto) target;
		if(!addGroupProductDto.isEdit()){
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.product.name");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "image", "NotEmpty.product.image");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "isSpecial", "NotEmpty.product.isSpecial");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "isLastest", "NotEmpty.product.isLastest");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "NotEmpty.product.description");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "NotEmpty.product.price");
		
		if(addGroupProductDto.getPrice()==0){
			errors.rejectValue("price", "NotEmpty.product.price.zero");
		}
	
	}


}
