package com.globacomp.ssystem.data;

public interface Model extends Createable, Updateable, Modifiable {

	public String getId();

	public void setId(String id);
}
