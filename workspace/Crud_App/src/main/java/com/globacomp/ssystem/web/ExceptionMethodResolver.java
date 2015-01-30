package com.globacomp.ssystem.web;

import java.lang.reflect.Method;

public interface ExceptionMethodResolver<C, T> {

	Method resolve(Class<C> delegateClass, String methodName);

	Method resolve(Class<C> delegateClass, Class<T> throwable);

}
