package com.globacomp.ssystem.data.dao.impl;

import org.springframework.stereotype.Repository;

import com.globacomp.ssystem.data.dao.UserDao;
import com.globacomp.ssystem.data.model.User;

@Repository("userDao")
public class UserDaoImpl extends AbstractApplicationDAO<User> implements UserDao {

	
}
