package com.globacomp.ssystem.web;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import com.globacomp.ssystem.web.exception.ResourceNotFoundException;

public class ErrorAwareRequestWrapper extends HttpServletResponseWrapper {

	public ErrorAwareRequestWrapper(HttpServletResponse httpServletResponse) {
		super(httpServletResponse);
	}

	public void sendError(int errorCode) throws IOException {

		if (errorCode == HttpServletResponse.SC_NOT_FOUND) {
			throw new ResourceNotFoundException();
		}

		super.sendError(errorCode);
	}
}
