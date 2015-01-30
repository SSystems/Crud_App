package com.globacomp.ssystem.web.form;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.stereotype.Component;


@Component("exceptionForm")
public class ExceptionForm extends AbstractApplicationForm {

	private Throwable throwable;

	public ExceptionForm() {
	}

	@Override
	public void doInit() {

		super.doInit();
	}

	public Throwable getThrowable() {
		return throwable;
	}

	public void setThrowable(Throwable throwable) {
		this.throwable = throwable;
	}

	public String getDetails() {
		String details = ExceptionUtils.getStackTrace(throwable);
		details = details.replace("at ", "<br/>at ");
		details = details.replace("Caused by: ", "<br/>Caused by: ");
		return details;
	}

}
