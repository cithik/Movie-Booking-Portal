package com.me.moviebooking.validator;


import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.me.moviebooking.model.Customer;



public class CustomerValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Customer.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Customer customer = (Customer) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName",
				 "validate.userName", "User name required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
				"validate.userName", "Password required");
	}
	
}