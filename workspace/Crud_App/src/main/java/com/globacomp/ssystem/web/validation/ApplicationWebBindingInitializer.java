package com.globacomp.ssystem.web.validation;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;

@Component("webBindingInitializer")
public class ApplicationWebBindingInitializer extends
		ConfigurableWebBindingInitializer {

	public ApplicationWebBindingInitializer() {
	}
}
