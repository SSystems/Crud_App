package com.globacomp.ssystem.data.dao.impl;

import org.springframework.stereotype.Repository;

import com.globacomp.ssystem.data.dao.CaseDao;
import com.globacomp.ssystem.data.model.Case;

@Repository("caseDao")
public class CaseDaoImpl extends AbstractApplicationDAO<Case> implements CaseDao {

}
