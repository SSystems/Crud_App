package com.globacomp.ssystem.web;

import java.lang.reflect.Method;

import com.globacomp.ssystem.web.controller.AbstractApplicationController;


@SuppressWarnings("rawtypes")
public abstract class AbstractExceptionMethodResolver<C extends AbstractApplicationController, T extends Throwable>
		implements ExceptionMethodResolver<C, T> {

	public AbstractExceptionMethodResolver() {
	}

	@Override
	public Method resolve(Class<C> delegateClass, Class<T> throwable) {
		return null;
	}

	@Override
	public Method resolve(Class<C> delegateClass, String methodName) {
		return null;
	}
}
