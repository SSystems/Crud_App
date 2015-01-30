package com.globacomp.ssystem.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.globacomp.ssystem.data.model.User;
import com.globacomp.ssystem.exception.UsernameNotAvailableException;
import com.globacomp.ssystem.service.AuthenticationService;
import com.globacomp.ssystem.web.form.RegistrationForm;
import com.globacomp.ssystem.web.form.validator.RegistrationFormValidator;

@Controller("signupController")
public class SignUpController extends AbstractApplicationController<RegistrationForm, RegistrationFormValidator> {

	@Autowired
	private AuthenticationService authenticationService;
	
	public String doForm(HttpServletRequest request, HttpServletResponse response, RegistrationForm form) {
		form.doInit();
		return REGISTRATION_VIEW;
	}
	
	public String doSubmit(HttpServletRequest request, HttpServletResponse response, HttpSession session, @Valid RegistrationForm form) {
		System.out.println("in submit");
		System.out.println(form.getUser().getEmail());
		
		User user = form.getUser();
		user.setLogin(form.getLogin());
		
		try {
			user = authenticationService.onboardUser(user);
		} catch (UsernameNotAvailableException e1) {
			form.getBindingResult().reject("username.unavailable");
			return (String) session.getAttribute(CURRENT_REQUEST_VIEW_NAME);
		}
		if(! StringUtils.isBlank(user.getId())) {
			try {
				response.sendRedirect(request.getContextPath()+"/login/init.do");
				
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}
		else 
			System.out.println("Error while saving user");
		
		return REGISTRATION_VIEW;
	}
}
