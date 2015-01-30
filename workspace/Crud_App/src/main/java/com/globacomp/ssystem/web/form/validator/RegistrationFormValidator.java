package com.globacomp.ssystem.web.form.validator;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.globacomp.ssystem.web.form.RegistrationForm;
import com.globacomp.ssystem.web.validation.AbstractApplicationValidator;

@Component
public class RegistrationFormValidator extends AbstractApplicationValidator<RegistrationForm>{

	@Override
	public void validateForm(RegistrationForm f, Errors errors) {
		// TODO Auto-generated method stub
		if(!validateByRegex(CHARACTERS_ONLY_PATTERN, f.getUser().getFirstName().trim())) {
			errors.rejectValue("user.firstName", "value.invalid");
		}
		
		if(!validateByRegex(CHARACTERS_ONLY_PATTERN, f.getUser().getLastName().trim())) {
			errors.rejectValue("user.lastName", "value.invalid");
		}
		
		if(!validateEmail(f.getUser().getEmail())) {
			errors.rejectValue("user.email", "value.invalid");
		}
		
		if(!validateUsername(f.getLogin().getUsername())) {
			errors.rejectValue("login.username", "username.invalid");
		}
		
		if(StringUtils.isBlank(f.getLogin().getPassword() )) {
			errors.rejectValue("login.password", "password.required");
		}
		
		if(StringUtils.isBlank(f.getConfirmPassword())) {
			errors.rejectValue("confirmPassword", "password.required");
		}
		
		if(!StringUtils.isBlank(f.getLogin().getPassword()) && 
				! StringUtils.isBlank(f.getConfirmPassword()) &&
				!f.getLogin().getPassword().equals(f.getConfirmPassword())) {
			
			errors.rejectValue("confirmPassword", "password.donot.match");
		}
		
		if(!f.isAgree()) {
			errors.rejectValue("isAgree", "terms.not.agreed");
		}
		
	}

}
