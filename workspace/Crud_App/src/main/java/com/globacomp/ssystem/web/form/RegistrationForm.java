package com.globacomp.ssystem.web.form;

import org.springframework.stereotype.Component;

import com.globacomp.ssystem.data.model.Login;
import com.globacomp.ssystem.data.model.User;

@Component
public class RegistrationForm extends AbstractApplicationForm {

	private User user;
	
	private Login login;
	
	private String confirmPassword;
	
	private boolean agree;
	
	@Override
	public void doInit() {
		// TODO Auto-generated method stub
		super.doInit();
		user = new User();
		login = new Login();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public boolean isAgree() {
		return agree;
	}

	public void setAgree(boolean agree) {
		this.agree = agree;
	}
	
	
	
}
