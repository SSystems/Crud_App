package com.globacomp.ssystem.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.globacomp.ssystem.data.dao.CaseDao;
import com.globacomp.ssystem.data.model.Case;
import com.globacomp.ssystem.data.model.CaseFile;
import com.globacomp.ssystem.service.CaseService;
import com.globacomp.ssystem.web.WebUser;
import com.globacomp.ssystem.web.form.CaseForm;

@Service("caseService")
public class CaseServiceImpl implements CaseService {

	@Autowired
	private CaseDao caseDao;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Case create(CaseForm caseForm) {
		// TODO Auto-generated method stub
		Case cas = new Case();
		Long random = (long) (Math.random() * Math.pow(10, 6));
		cas.setUCR(String.valueOf(random));
		WebUser loggedInUser = WebUser.getUser();
		System.out.println("Logged:"+loggedInUser.getId());
		
		CaseFile caseFile = new CaseFile();
		try {
			caseFile.setContent(caseForm.getFile().getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		caseFile.setFileName(caseForm.getFile().getOriginalFilename());
		caseFile.setAssociatedCase(cas);
		cas.getCaseFiles().add(caseFile);
		
		return create(cas);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public Case create(Case casee) {
		// TODO Auto-generated method stub
		return caseDao.create(casee);
	}

	@Override
	public List<Case> listAll() {
		return caseDao.findAll();
	}

}
