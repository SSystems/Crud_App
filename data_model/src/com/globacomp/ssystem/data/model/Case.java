package com.globacomp.ssystem.data.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name = "case_master", uniqueConstraints = {
		@UniqueConstraint(columnNames = "ucr")
		 })
public class Case extends AbstractModel {
	
	private String UCR;
	
	private boolean isAssigned;
	
	private Set<CaseFile> caseFiles = new HashSet<CaseFile>(0);
	
	private User owner;
	
	public Case() {
		// TODO Auto-generated constructor stub
	}

	@Column(name="ucr", nullable=false)
	public String getUCR() {
		return UCR;
	}

	public void setUCR(String uCR) {
		UCR = uCR;
	}

	@Transient
	public boolean isAssigned() {
		return isAssigned;
	}

	public void setAssigned(boolean isAssigned) {
		this.isAssigned = isAssigned;
	}

	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, 
			mappedBy="associatedCase")
	public Set<CaseFile> getCaseFiles() {
		return caseFiles;
	}

	public void setCaseFiles(Set<CaseFile> caseFiles) {
		this.caseFiles = caseFiles;
	}
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="OWNER_ID", nullable =false )
	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}
	
	
}
