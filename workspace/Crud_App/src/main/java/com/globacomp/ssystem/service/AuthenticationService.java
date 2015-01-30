package com.globacomp.ssystem.service;

import com.globacomp.ssystem.data.model.Login;
import com.globacomp.ssystem.data.model.User;
import com.globacomp.ssystem.exception.UsernameNotAvailableException;

public interface AuthenticationService extends ApplicationService {

	Login findByUsername(String username);
	
	Login find(Login login);
	
	User onboardUser(User user) throws UsernameNotAvailableException;
}
