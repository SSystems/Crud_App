package com.globacomp.ssystem.exception;

public class UsernameNotAvailableException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private static final String messge = "Username is not available: ";
	
	public UsernameNotAvailableException(String username) {
		super(messge+ username);
	}
}
