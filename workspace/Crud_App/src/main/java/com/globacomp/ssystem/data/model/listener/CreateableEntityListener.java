package com.globacomp.ssystem.data.model.listener;

import java.util.Date;

import javax.persistence.PrePersist;

import com.globacomp.ssystem.data.Createable;
import com.globacomp.ssystem.web.WebUser;

public class CreateableEntityListener {

	public CreateableEntityListener() {
	}

	@PrePersist
	public void onPrePersist(final Createable entity) {

		WebUser user = WebUser.getUser();
		String createdBy = user.getId();

		entity.setCreationDate(new Date());
		entity.setCreatedBy("system");
	}
}
