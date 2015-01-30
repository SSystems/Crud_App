package com.globacomp.ssystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.globacomp.ssystem.data.dao.LoginDao;
import com.globacomp.ssystem.data.dao.UserDao;
import com.globacomp.ssystem.data.model.Login;
import com.globacomp.ssystem.data.model.User;
import com.globacomp.ssystem.exception.UsernameNotAvailableException;
import com.globacomp.ssystem.service.AuthenticationService;

@Service("authenticationService")
public class AuthenticationServiceImpl implements AuthenticationService {

	@Autowired
	private LoginDao loginDao;
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public Login findByUsername(String username) {
		return loginDao.findByUsername(username);
	}

	@Override
	public Login find(Login login) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public User onboardUser(User user) throws UsernameNotAvailableException {

		String username = user.getLogin().getUsername();
		Login login = loginDao.findByUsername(username);
		
		if(login!=null){
			throw new UsernameNotAvailableException(username);
		}
		
		return userDao.create(user);
		
	}


}
