package com.globacomp.ssystem.web;

import java.lang.reflect.Method;

import com.globacomp.ssystem.web.controller.AbstractApplicationController;


@SuppressWarnings("rawtypes")
public abstract class AbstractHandlerMethodResolver<T extends AbstractApplicationController>
		implements HandlerMethodResolver<T> {

	public AbstractHandlerMethodResolver() {
	}

	@Override
	public Method resolve(Class<T> delegateClass, String methodName) {
		return null;
	}
}
