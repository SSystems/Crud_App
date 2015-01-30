package com.globacomp.ssystem.data.model.listener;

import javax.persistence.PrePersist;

import com.globacomp.ssystem.common.Configuration;
import com.globacomp.ssystem.data.Modifiable;

public class ModifiableEntityListener {

	public ModifiableEntityListener() {
	}

	@PrePersist
	public void onPrePersist(final Modifiable entity) {

			entity.setStatus(Configuration.STATUS.ACTIVE.getStatus());
	}
}
