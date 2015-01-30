package com.globacomp.ssystem.web.resolver;

import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.globacomp.ssystem.web.AbstractExceptionMethodResolver;
import com.globacomp.ssystem.web.controller.AbstractApplicationController;
import com.globacomp.ssystem.web.exception.ResourceNotFoundException;

@SuppressWarnings("rawtypes")
@Component("exceptionMethodResolver")
public class ControllerBasedExceptionMethodResolver
		extends
		AbstractExceptionMethodResolver<AbstractApplicationController, Throwable> {

	public ControllerBasedExceptionMethodResolver() {
	}

	@Override
	public Method resolve(Class<AbstractApplicationController> delegateClass,
			String methodName) {

		Method[] methods = delegateClass.getMethods();

		for (Method method : methods) {

			if (isExceptionHandlerMethod(method)) {

				String name = method.getName();
				if (methodName.equals(name)) {
					return method;
				}
			}
		}

		throw new ResourceNotFoundException("No handler methods in class ["
				+ delegateClass + "]");
	}

	@Override
	public Method resolve(Class<AbstractApplicationController> delegateClass,
			Class<Throwable> throwable) {

		Method[] methods = delegateClass.getMethods();

		for (Method method : methods) {
			if (isExceptionHandlerMethod(method)) {

				Class<?> cl = method.getParameterTypes()[2];

				if (cl.isAssignableFrom(throwable)) {

					return method;
				}
			}
		}

		throw new ResourceNotFoundException("No Exception methods in class ["
				+ delegateClass + "]");
	}

	private boolean isExceptionHandlerMethod(Method method) {

		Class<?>[] parameterTypes = method.getParameterTypes();
		int length = parameterTypes.length;

		return (isHandlerMethod(method) && length == 3 && Throwable.class
				.isAssignableFrom(parameterTypes[2]));
	}

	public boolean isHandlerMethod(Method method) {

		Class<?> returnType = method.getReturnType();
		String methodName = method.getName();

		if (ModelAndView.class.equals(returnType)
				|| Map.class.equals(returnType)
				|| String.class.equals(returnType)
				|| void.class.equals(returnType)) {

			Class<?>[] parameterTypes = method.getParameterTypes();
			int length = parameterTypes.length;

			return (length >= 2
					&& HttpServletRequest.class.equals(parameterTypes[0])
					&& HttpServletResponse.class.equals(parameterTypes[1]) && !("handleRequest"
					.equals(methodName) && length == 2));
		}

		return false;
	}
}
