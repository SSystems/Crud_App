package com.globacomp.ssystem.data.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_master")
public class User extends AbstractModel {

	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String gender;
	
	private byte active;
	
	private Login login;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	@Column(name = "first_name", nullable = false)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "last_name", nullable = false)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "email", nullable = false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name = "gender", nullable = false)
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "active", nullable = false)
	public byte getActive() {
		return active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="user")
	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
	
	
	
}
