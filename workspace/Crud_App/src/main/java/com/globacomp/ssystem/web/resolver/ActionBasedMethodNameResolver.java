package com.globacomp.ssystem.web.resolver;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.mvc.multiaction.MethodNameResolver;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

@Component("methodNameResolver")
public class ActionBasedMethodNameResolver<T> implements MethodNameResolver {

	public static final String HTTP_PARAMETER_NAME = "action_method_name";

	public static final String DEFAULT_METHOD_NAME = "doInit";

	public ActionBasedMethodNameResolver() {
	}

	@Override
	public String getHandlerMethodName(HttpServletRequest request)
			throws NoSuchRequestHandlingMethodException {

		String actionName = request.getParameter(HTTP_PARAMETER_NAME);
		if (actionName != null && actionName.length() > 0) {
			return actionName;
		}

		StringBuffer requestURL = request.getRequestURL();
		String url = requestURL.toString();

		if (url != null && url.length() > 0 && url.endsWith(".do")) {

			int startIndex = url.lastIndexOf("/") + 1;
			int endIndex = url.length() - 3;

			String methodName = url.substring(startIndex, endIndex);
			methodName = "do" + StringUtils.capitalize(methodName);

			return methodName;
		}

		return DEFAULT_METHOD_NAME;
	}
}
