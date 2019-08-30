package com.journaldev.spring.form.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.journaldev.spring.form.model.Test;

public class TestValidator implements Validator {
	
	public boolean supports(Class<?> paramClass) {
		return Test.class.equals(paramClass);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "test", "name.required");
		
	}

}
