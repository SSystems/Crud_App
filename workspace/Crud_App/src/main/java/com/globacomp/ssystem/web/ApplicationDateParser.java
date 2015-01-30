package com.globacomp.ssystem.web;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.util.StringUtils;


public class ApplicationDateParser extends PropertyEditorSupport {

	private static final List<String> formats = new ArrayList<String>();

	private String outputFormat;

	static {
		formats.add("dd/MM/yyyy hh:mm:ss");
		formats.add("dd/MM/yyyy hh:mm:ss");
		formats.add("yyyy-MM-dd");
		formats.add("yyyy-MM-dd hh:mm:ss");
		formats.add("yyyy-MM-dd hh:mm:ss.SSS");
		// formats.add("yyyy-MM-dd hh:mm:ss");
		formats.add("MM-dd-yyyy hh:mm:ss");

	}

	public ApplicationDateParser() {
	}

	public ApplicationDateParser(String outputFormat) {
		this.outputFormat = outputFormat;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {

		text = text + " 12:00:00";

		if (StringUtils.isEmpty(text)) {
			return;
		}

		Date dt = null;

		for (String format : formats) {

			try {
				SimpleDateFormat dateFormat = new SimpleDateFormat(format);
				dateFormat.setLenient(false);
				dt = dateFormat.parse(text);
				break;

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (dt != null) {
			setValue(dt);
		}
	}

	@Override
	public String getAsText() {

		Date date = (Date) getValue();
		String text = null;

		for (String format : formats) {

			try {

				SimpleDateFormat dateFormat = new SimpleDateFormat(format);
				dateFormat.setLenient(false);

				text = dateFormat.format(date);

				break;

			} catch (Exception e) {
			}
		}

		if (text != null) {
			return text;
		}

		return "";
	}

}
