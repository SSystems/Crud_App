package com.globacomp.ssystem.web.form;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.globacomp.ssystem.web.WebUser;


/**
 * An instance of the command class will be created for each request and
 * populated with request parameters. A command class can basically be any Java
 * class; the only requirement is a no argument constructor. The command class
 * should preferably be a JavaBean in order to be able to populate bean
 * properties with request parameters
 */
public abstract class AbstractApplicationForm implements ApplicationForm,
		Initializable {

	private boolean isInitialized = false;;

	private BindingResult bindingResult;

	public AbstractApplicationForm() {
	}

	@Override
	public void doInit() {
		this.isInitialized = true;
	}

	public boolean hasErrors() {
		return this.bindingResult.hasErrors();
	}

	public boolean isInitialized() {
		return isInitialized;
	}

	public void setInitialized(boolean isInitialized) {
		this.isInitialized = isInitialized;
	}

	public BindingResult getBindingResult() {
		return bindingResult;
	}

	public void setBindingResult(BindingResult bindingResult) {
		this.bindingResult = bindingResult;
	}

	public List<ObjectError> getErrors() {
		if (this.bindingResult != null) {
			return this.bindingResult.getAllErrors();
		}
		return new ArrayList<ObjectError>();
	}

	public boolean isAuthentic() {
		WebUser user = WebUser.getUser();
		if (user == null) {
			return false;
		}
		return true;
	}

	public boolean isValid() {

		if (this.bindingResult == null) {
			return true;
		}

		if (this.bindingResult.hasErrors()) {
			return false;
		}

		return true;
	}

}
