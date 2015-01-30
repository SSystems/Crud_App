package com.globacomp.ssystem.web.form.validator;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.globacomp.ssystem.web.form.LoginForm;
import com.globacomp.ssystem.web.validation.AbstractApplicationValidator;

@Component
public class LoginFormValidator extends AbstractApplicationValidator<LoginForm>{

	private String usernamePattern;
	
	@Override
	public void validateForm(LoginForm f, Errors errors) {
		if(StringUtils.isBlank(f.getUsername())){
			errors.rejectValue("username", "username.required");
		}
		if(StringUtils.isBlank(f.getPassword())){
			errors.rejectValue("password", "password.required");
		}
			
	}

}
