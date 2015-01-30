package com.globacomp.ssystem.service;

import java.util.List;

import com.globacomp.ssystem.data.model.Case;
import com.globacomp.ssystem.web.form.CaseForm;

public interface CaseService extends ApplicationService {

	Case create(CaseForm caseForm);
	
	Case create(Case casee);
	
	List<Case> listAll();
}
