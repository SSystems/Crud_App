package com.globacomp.ssystem.data.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

import com.globacomp.ssystem.data.Model;


@MappedSuperclass
public abstract class AbstractModel implements Model {

	/** Generated Serial Version UID */
	private static final long serialVersionUID = -1L;

	protected String id;
	protected String createdBy;
	protected Date creationDate;
	protected String lastUpdateBy;
	protected Date lastUpdateDate;
	protected byte status;

	public AbstractModel() {
	}

	@Id
	@GeneratedValue(generator = "generator")
	@GenericGenerator(name = "generator", strategy = "uuid2")
	@Column(name = "id", columnDefinition = "id", unique = true, nullable = false, length = 36)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "created_by", columnDefinition = "created_by", nullable = false, length = 36)
	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name = "creation_date", columnDefinition = "creation_date", nullable = false)
	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Column(name = "last_update_by", columnDefinition = "last_update_by", length = 36)
	public String getLastUpdateBy() {
		return this.lastUpdateBy;
	}

	public void setLastUpdateBy(String lastUpdateBy) {
		this.lastUpdateBy = lastUpdateBy;
	}

	@Column(name = "last_update_date", columnDefinition = "last_update_date")
	public Date getLastUpdateDate() {
		return this.lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	@Column(name = "status", columnDefinition = "status", nullable = false)
	public byte getStatus() {
		return this.status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}
}
