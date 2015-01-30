package com.globacomp.ssystem.data.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "login_master", uniqueConstraints = {
		@UniqueConstraint(columnNames = "username")
		 })
public class Login extends AbstractModel {

	private String username;
	
	private String password;
	
	private byte active;
	
	private Date lastLoginTime;
	
	private User user;
	
	public Login() {
		// TODO Auto-generated constructor stub
	}
	@Column(name = "username", unique = true, nullable = false, length = 128)
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	@Column(name = "password", nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name = "active", nullable = false)
	public byte getActive() {
		return active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "last_login_time")
	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	
	@OneToOne( fetch= FetchType.LAZY)
	@JoinColumn(name="user_id")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
