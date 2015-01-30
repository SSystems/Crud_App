package com.globacomp.ssystem.web.form;

import org.springframework.stereotype.Component;

@Component
public class LoginForm extends AbstractApplicationForm {

	private String username;
	
	private String password;

	public LoginForm() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void doInit() {
		super.doInit();
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
