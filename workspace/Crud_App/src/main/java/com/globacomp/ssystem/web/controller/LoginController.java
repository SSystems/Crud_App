package com.globacomp.ssystem.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.globacomp.ssystem.data.model.Login;
import com.globacomp.ssystem.service.AuthenticationService;
import com.globacomp.ssystem.web.form.LoginForm;
import com.globacomp.ssystem.web.form.validator.LoginFormValidator;

@Controller
public class LoginController extends AbstractApplicationController<LoginForm, LoginFormValidator>{

	@Autowired
	private AuthenticationService authenticationService;
	
	public String doInit(HttpServletRequest request, HttpServletResponse response){
		return LOGIN_VIEW;
	}
	
	public String doAuthenticate(HttpServletRequest request, HttpServletResponse response, HttpSession session, @Valid LoginForm loginForm) throws IOException{
	
		System.out.println("Authenticating username:"+loginForm.getUsername());
		Login login = authenticationService.findByUsername(loginForm.getUsername());

		
		if(login == null) {	
			loginForm.getBindingResult().reject("username.invalid");
			return LOGIN_VIEW;
		}
		if(login.getPassword().equals(loginForm.getPassword()))
			response.sendRedirect(request.getContextPath()+"/home/init.do");
		
		
		loginForm.getBindingResult().reject("authentication.failed");
		return LOGIN_VIEW;
		
	}
}
