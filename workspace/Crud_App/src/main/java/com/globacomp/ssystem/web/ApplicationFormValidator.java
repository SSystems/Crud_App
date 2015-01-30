package com.globacomp.ssystem.web;

import org.springframework.validation.Errors;

public interface ApplicationFormValidator<F> {

	void validateForm(F f, Errors errors);
}
