package com.globacomp.ssystem.data;

import java.io.Serializable;

public interface Modifiable extends Serializable {

	public byte getStatus();

	public void setStatus(byte status);
}
