package com.globacomp.ssystem.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.globacomp.ssystem.data.model.Case;
import com.globacomp.ssystem.service.CaseService;
import com.globacomp.ssystem.web.form.CaseForm;
import com.globacomp.ssystem.web.form.validator.CaseFormValidator;

@Controller("caseController")
public class CaseController extends AbstractApplicationController<CaseForm, CaseFormValidator> {
	
	@Autowired
	private CaseService caseService;
	
	public String doNew(HttpServletRequest request, HttpServletResponse response) {
		
		return CASE_UPLOAD_VIEW;
	}
	
	public String doUpload(HttpServletRequest request, HttpServletResponse response, HttpSession session, CaseForm caseForm) {
		System.out.println("In Upload");
		System.out.println(caseForm.getFile().getOriginalFilename());
		Case cas = caseService.create(caseForm);
		System.out.println(cas.getId());
		return CASE_UPLOAD_VIEW;
	}
	
	public String doList(HttpServletRequest request, HttpServletResponse response, HttpSession session, CaseForm caseForm) {
		caseForm.setCasesList(caseService.listAll());
		return CASE_LIST_VIEW;
	}
}
