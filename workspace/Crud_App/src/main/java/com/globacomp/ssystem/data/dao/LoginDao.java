package com.globacomp.ssystem.data.dao;

import com.globacomp.ssystem.data.model.Login;

public interface LoginDao extends ApplicationDAO<Login>{

	Login findByUsername(String username);
	
	Login find(Login login);
}
