	package com.globacomp.ssystem.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;

import com.globacomp.ssystem.web.form.HomeForm;
import com.globacomp.ssystem.web.form.validator.HomeFormValidator;

@Controller 
public class HomeController extends AbstractApplicationController<HomeForm, HomeFormValidator>{

	public String doInit(HttpServletRequest request, HttpServletResponse response){
		return "homeView";
	}
	
}
