package com.globacomp.ssystem.web;

import java.lang.reflect.Method;

public interface HandlerMethodResolver<T> {

	public Method resolve(Class<T> delegateClass, String methodName);

}
