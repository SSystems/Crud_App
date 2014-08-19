package com.globacomp.login;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DataHelper {

	public static boolean verifyuser(String username, String password) {

		Configuration cfg = new Configuration();

		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session sessionobj = factory.openSession();
		Loginbean log = new Loginbean();
		log.setUsername(username);
		
		// read from DB
		Loginbean obj = (Loginbean) sessionobj.get(Loginbean.class, log);

		/*
		 * if (username ==null|| username.trim().length()==0 || password ==null
		 * || password.trim().length()==0)
		 */
		boolean flag = false;
		if (obj != null && obj.getPassword().equals(password))
			
			flag = true;
				
		sessionobj.close();
		factory.close();
		return flag;
	}
	public static boolean adduser(String name, String password, String email, double ctc) {

		Configuration cfg = new Configuration();

		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session sessionobj = factory.openSession();
		RegisterBean Reg = new RegisterBean();
		Reg.setId(null);
		Reg.setEmail(email);
		Reg.setName(name);
		Reg.setPassword(password);
		Reg.setCtc(ctc);
		// Write to DB
		Transaction trans = sessionobj.beginTransaction();
		sessionobj.persist(Reg);
		trans.commit();
		sessionobj.close();
		factory.close();
		return true;
	}
	public static boolean addloginuser(String username, String password) {

		Configuration cfg = new Configuration();

		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session sessionobj = factory.openSession();
		Loginbean newlog = new Loginbean();
		newlog.setId(null);
		newlog.setUsername(username);
		newlog.setPassword(password);
				// Write to DB
		Transaction trans = sessionobj.beginTransaction();
		sessionobj.persist(newlog);
		trans.commit();
		sessionobj.close();
		factory.close();
		return true;
	}
	public static boolean updateuser( String name, String password, String email, double ctc) {

		Configuration cfg = new Configuration();

		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session sessionobj = factory.openSession();
		RegisterBean Regup = (RegisterBean) sessionobj.load(RegisterBean.class,name);
		Regup.setEmail(email);
		Regup.setPassword(password);
		Regup.setCtc(ctc);
		// Write to DB
		Transaction trans = sessionobj.beginTransaction();
		sessionobj.saveOrUpdate(Regup);
		trans.commit();
		sessionobj.close();
		factory.close();
		return true;
	}
	 
}
