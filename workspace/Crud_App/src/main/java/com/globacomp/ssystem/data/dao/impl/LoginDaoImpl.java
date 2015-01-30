package com.globacomp.ssystem.data.dao.impl;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.globacomp.ssystem.data.dao.LoginDao;
import com.globacomp.ssystem.data.model.Login;

@Repository("loginDao")
public class LoginDaoImpl extends AbstractApplicationDAO<Login> implements LoginDao {

	@Override
	public Login findByUsername(String username) {
		StringBuilder queryString = new StringBuilder();
		queryString.append("select login from Login login ");
		queryString.append("where login.username =:username ");
		queryString.append("and status= :status ");
		
		TypedQuery<Login> query = entityManager.createQuery(queryString.toString(), Login.class);
		query.setParameter("username", username);
		query.setParameter("status", (byte)1);
		
		Login login = null;
		try{
			login = query.getSingleResult();	
		} catch(Exception e){
			System.err.println(e.getMessage());
		}
		return login;
	}

	@Override
	public Login find(Login login) {
		// TODO Auto-generated method stub
		return null;
	}


}
