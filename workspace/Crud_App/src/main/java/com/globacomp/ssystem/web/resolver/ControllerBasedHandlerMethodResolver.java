package com.globacomp.ssystem.web.resolver;

import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.globacomp.ssystem.web.AbstractHandlerMethodResolver;
import com.globacomp.ssystem.web.controller.AbstractApplicationController;

@SuppressWarnings("rawtypes")
@Component("handlerMethodResolver")
public class ControllerBasedHandlerMethodResolver extends
		AbstractHandlerMethodResolver<AbstractApplicationController> {

	public ControllerBasedHandlerMethodResolver() {
	}

	@Override
	public Method resolve(Class<AbstractApplicationController> delegateClass,
			String methodName) {

		Method[] methods = delegateClass.getMethods();

		for (Method method : methods) {

			if (isHandlerMethod(method)) {

				String name = method.getName();
				if (methodName.equals(name)) {
					return method;
				}
			}
		}

		throw new IllegalStateException("No handler methods in class ["
				+ delegateClass + "]");
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
