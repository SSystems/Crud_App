package com.globacomp.ssystem.web.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.globacomp.ssystem.web.ApplicationFormValidator;
import com.globacomp.ssystem.web.form.AbstractApplicationForm;

public abstract class AbstractApplicationValidator<F extends AbstractApplicationForm>
		implements ApplicationFormValidator<F>, Validator {
	
	protected final Pattern CHARACTERS_ONLY_PATTERN = Pattern.compile("([a-zA-Z])*");
	
	private final Pattern USERNAME_PATTERN = Pattern.compile("\\w+");
	
	public AbstractApplicationValidator() {
	}

	@Override
	public boolean supports(Class<?> clazz) {

		return AbstractApplicationForm.class.isAssignableFrom(clazz);
	}

	@SuppressWarnings("unchecked")
	public void validate(Object command, Errors errors) {

		if (command instanceof AbstractApplicationForm) {

			F applicationForm = (F) command;

			validateForm(applicationForm, errors);
			
		}
	}

	public abstract void validateForm(F f, Errors errors);
	
	public boolean validateByRegex(String regex, String value) {
	
		Pattern pattern = Pattern.compile(regex);
		return validateByRegex(pattern, value);	
	}

	public boolean validateByRegex(Pattern pattern, String value) {
	
		Matcher matcher = pattern.matcher(value);
		return matcher.matches();
	}

	public boolean validateEmail(String email) {
		EmailValidator emailValidator = EmailValidator.getInstance();
		return emailValidator.isValid(email);
	}
	
	public boolean validateUsername(String username) {
		return validateByRegex(USERNAME_PATTERN, username);
	}
}
