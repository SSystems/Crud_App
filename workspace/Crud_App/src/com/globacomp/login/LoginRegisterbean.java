package com.globacomp.login;

import com.opensymphony.xwork2.ActionSupport;

public class LoginRegisterbean extends ActionSupport {
	private String username;
	private String password;
	private Integer id;
	private String confirmpassword;


	public String execute() throws Exception {

		if (getUsername() == null || getUsername().trim().length() == 0
				|| getPassword() == null || getPassword().trim().length() == 0||!(getPassword().equals(getConfirmpassword())))

			return INPUT;
		else if(DataHelper.addloginuser(getUsername(), getPassword()))
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getConfirmpassword() {
		return confirmpassword;
	}

	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}


}
