package com.globacomp.login;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class RegisterBean extends ActionSupport{
	public String execute() throws Exception {
		
		if (getName() == null || getName().trim().length() == 0
				|| getPassword() == null || getPassword().trim().length() == 0)

			return INPUT;
		else if(DataHelper.adduser(name, password, email, ctc))
			return SUCCESS;
		else
			return INPUT;

	}
	
	private Integer id;
	private String name;
	private String password;
	private String email;
	private double ctc;
	
		public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public double getCtc() {
		return ctc;
	}
	public void setCtc(double ctc) {
		this.ctc = ctc;
	}
	

	
}
	
	
