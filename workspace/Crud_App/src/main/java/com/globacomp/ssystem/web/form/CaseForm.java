package com.globacomp.ssystem.web.form;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.globacomp.ssystem.data.model.Case;

@Component
public class CaseForm extends AbstractApplicationForm {
	
	private List<Case> casesList;
	
	private MultipartFile file;

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public List<Case> getCasesList() {
		return casesList;
	}

	public void setCasesList(List<Case> casesList) {
		this.casesList = casesList;
	}
	
	
	
}
