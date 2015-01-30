package com.globacomp.ssystem.data;

import java.io.Serializable;
import java.util.Date;

public interface Updateable extends Serializable {

	public String getLastUpdateBy();

	public void setLastUpdateBy(String lastUpdateBy);

	public Date getLastUpdateDate();

	public void setLastUpdateDate(Date lastUpdateDate);
}
