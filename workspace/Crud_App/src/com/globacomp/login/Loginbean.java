package com.globacomp.login;

import com.opensymphony.xwork2.ActionSupport;

public class Loginbean extends ActionSupport {
	private String username;
	private String password;

	public String execute() throws Exception {

		if (getUsername() == null || getUsername().trim().length() == 0
				|| getPassword() == null || getPassword().trim().length() == 0)

			return INPUT;
		else if(DataHelper.verifyuser(getUsername(), getPassword()))
			return SUCCESS;
		else
			return INPUT;

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
