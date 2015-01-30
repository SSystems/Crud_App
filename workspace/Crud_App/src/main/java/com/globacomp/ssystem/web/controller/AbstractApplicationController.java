package com.globacomp.ssystem.web.controller;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.mvc.multiaction.MethodNameResolver;

import com.globacomp.ssystem.web.ApplicationDateParser;
import com.globacomp.ssystem.web.ExceptionMethodResolver;
import com.globacomp.ssystem.web.HandlerMethodResolver;
import com.globacomp.ssystem.web.common.ApplicationViewNames;
import com.globacomp.ssystem.web.form.AbstractApplicationForm;
import com.globacomp.ssystem.web.form.ExceptionForm;
import com.globacomp.ssystem.web.validation.AbstractApplicationValidator;
import com.globacomp.ssystem.web.validation.ApplicationWebBindingInitializer;

public abstract class AbstractApplicationController<F extends AbstractApplicationForm, V extends AbstractApplicationValidator<F>>
		extends AbstractController implements ApplicationController,
		ApplicationContextAware, ApplicationViewNames {

	/** Suffix for last-modified methods */
	public static final String LAST_MODIFIED_METHOD_SUFFIX = "LastModified";

	public static final String DEFAULT_COMMAND_NAME = "command";

	@Autowired
	protected MethodNameResolver methodNameResolver;

	@Autowired
	private WebBindingInitializer webBindingInitializer;

	@SuppressWarnings("rawtypes")
	@Autowired
	protected HandlerMethodResolver handlerMethodResolver;

	@SuppressWarnings("rawtypes")
	@Autowired
	protected ExceptionMethodResolver exceptionMethodResolver;

	public AbstractApplicationController() {
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public final F getApplicationForm() {

		Class<? extends AbstractApplicationController> thisClass = getClass();
		Type type = thisClass.getGenericSuperclass();
		if (type instanceof ParameterizedType) {
			ParameterizedType parameterizedType = (ParameterizedType) type;
			Type[] actualTypeArguments = parameterizedType
					.getActualTypeArguments();
			Class<F> applicationFormClass = (Class<F>) actualTypeArguments[0];

			ApplicationContext applicationContext = super
					.getApplicationContext();
			return applicationContext.getBean(applicationFormClass);
		}

		throw new IllegalStateException(thisClass + " is not assignable from "
				+ AbstractApplicationController.class);
	}

	public final F getApplicationForm(Class<F> applicationFormClass) {

		ApplicationContext applicationContext = super.getApplicationContext();
		return applicationContext.getBean(applicationFormClass);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public final Class<F> getApplicationFormClass() {

		Class<? extends AbstractApplicationController> thisClass = getClass();
		Type type = thisClass.getGenericSuperclass();
		if (type instanceof ParameterizedType) {
			ParameterizedType parameterizedType = (ParameterizedType) type;
			Type[] actualTypeArguments = parameterizedType
					.getActualTypeArguments();
			Class<F> applicationFormClass = (Class<F>) actualTypeArguments[0];

			return applicationFormClass;
		}

		throw new IllegalStateException(thisClass + " is not assignable from "
				+ AbstractApplicationController.class);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public final V getApplicationValidator() {

		Class<? extends AbstractApplicationController> thisClass = getClass();
		Type type = thisClass.getGenericSuperclass();
		if (type instanceof ParameterizedType) {
			ParameterizedType parameterizedType = (ParameterizedType) type;
			Type[] actualTypeArguments = parameterizedType
					.getActualTypeArguments();
			Class<V> applicationValidatorClass = (Class<V>) actualTypeArguments[1];

			ApplicationContext applicationContext = super
					.getApplicationContext();
			return applicationContext.getBean(applicationValidatorClass);
		}

		throw new IllegalStateException(thisClass + " is not assignable from "
				+ AbstractApplicationController.class);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String methodName = this.methodNameResolver
				.getHandlerMethodName(request);
		Class<?> thisClass = this.getClass();

		Method method = handlerMethodResolver.resolve(thisClass, methodName);
		Class<?>[] paramTypes = method.getParameterTypes();

		int paramTypesLength = paramTypes.length;
		Object[] params = new Object[paramTypesLength];

		HttpSession session = request.getSession(false);
		if (session == null)
		{
			session = request.getSession(true);	
		}

		Class<F> applicationFormClass = getApplicationFormClass();
		F applicationForm = getApplicationForm(applicationFormClass);
		applicationForm.doInit();

		BindingResult bindingResult = bind(request, applicationForm);
		applicationForm.setBindingResult(bindingResult);

		for (int i = 0; i < paramTypesLength; i++) {

			if (HttpServletRequest.class.equals(paramTypes[i])) {

				params[i] = request;

			} else if (HttpServletResponse.class.equals(paramTypes[i])) {

				params[i] = response;

			} else if (HttpSession.class.equals(paramTypes[i])) {

				params[i] = session;

			} else if (applicationFormClass.isAssignableFrom(paramTypes[i])) {

				Annotation[][] parameterAnnotations = method
						.getParameterAnnotations();
				Annotation[] formAnnotations = parameterAnnotations[i];

				for (Annotation annotation : formAnnotations) {

					boolean validateForm = Valid.class.equals(annotation
							.annotationType());

					if (validateForm) {

						bindingResult = handleDefaultValidation(bindingResult,
								applicationForm);

						if (applicationForm.hasErrors()) {

							String viewName = (String) session
									.getAttribute(CURRENT_REQUEST_VIEW_NAME);

							ModelAndView modelAndView = new ModelAndView();

							Map<String, Object> model = bindingResult
									.getModel();
							modelAndView.addAllObjects(model);

							modelAndView.setViewName(viewName);

							return modelAndView;
						}

						bindingResult = handleFormValidation(bindingResult,
								applicationForm);

						if (applicationForm.hasErrors()) {

							String viewName = (String) session
									.getAttribute(CURRENT_REQUEST_VIEW_NAME);

							ModelAndView modelAndView = new ModelAndView();

							Map<String, Object> model = bindingResult
									.getModel();
							modelAndView.addAllObjects(model);

							modelAndView.setViewName(viewName);

							return modelAndView;

						}
					}
				}

				params[i] = applicationForm;

			} else if (Throwable.class.isAssignableFrom(paramTypes[i])) {

				// handle exception here ...

			} else {

				throw new IllegalStateException("No handler object found for "
						+ paramTypes[i]);
			}
		}

		Object returnValue = method.invoke(this, params);
		//System.out.println("return value ->"+returnValue);
		if (returnValue instanceof ModelAndView) {

			ModelAndView modelAndView = (ModelAndView) returnValue;
			if (modelAndView != null) {

				Map<String, Object> model = bindingResult.getModel();
				modelAndView.addAllObjects(model);
			}

			session.setAttribute(CURRENT_REQUEST_VIEW_NAME, modelAndView.getViewName());

			return modelAndView;

		} else if (returnValue instanceof Map) {

			Map returnValueMap = (Map) returnValue;

			ModelAndView modelAndView = new ModelAndView();
			modelAndView = modelAndView.addAllObjects(returnValueMap);

			Map<String, Object> model = bindingResult.getModel();
			modelAndView.addAllObjects(model);

			session.setAttribute(CURRENT_REQUEST_VIEW_NAME, modelAndView.getViewName());

			return modelAndView;

		} else if (returnValue instanceof String) {

			String viewName = (String) returnValue;

			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName(viewName);

			Map<String, Object> model = bindingResult.getModel();
			modelAndView.addAllObjects(model);
			
			//System.out.println("session ->"+session.toString());
			//System.out.println("viewName ->"+viewName);
			if (!"logoutView".equals(viewName)) {
				session.setAttribute(CURRENT_REQUEST_VIEW_NAME, viewName);
			}

			return modelAndView;

		} else {

			return null;
		}
	}

	protected BindingResult bind(HttpServletRequest httpServletRequest, F f) {

		ServletRequestDataBinder binder = createBinder(httpServletRequest, f);
		binder.bind(httpServletRequest);

		BindingResult bindingResult = binder.getBindingResult();

		return bindingResult;
	}

	protected BindingResult handleFormValidation(BindingResult bindingResult,
			F f) {

		V validator = getApplicationValidator();

		ValidationUtils.invokeValidator(validator, f, bindingResult);

		return bindingResult;
	}

	protected BindingResult handleDefaultValidation(
			BindingResult bindingResult, F f) {

		ApplicationWebBindingInitializer applicationWebBindingInitializer = (ApplicationWebBindingInitializer) webBindingInitializer;
		Validator validator = applicationWebBindingInitializer.getValidator();

		ValidationUtils.invokeValidator(validator, f, bindingResult);

		return bindingResult;
	}

	protected String getCommandName(Object command) {
		return DEFAULT_COMMAND_NAME;
	}

	protected ServletRequestDataBinder createBinder(HttpServletRequest request,
			Object command) {

		String commandName = getCommandName(command);

		ServletRequestDataBinder binder = new ServletRequestDataBinder(command,
				commandName);
		binder.setAutoGrowNestedPaths(true);
		binder.setBindEmptyMultipartFiles(true);

		initBinder(request, binder);
		return binder;
	}

	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) {

		if (this.webBindingInitializer != null) {
			ServletWebRequest servletWebRequest = new ServletWebRequest(request);
			this.webBindingInitializer.initBinder(binder, servletWebRequest);
		}
		binder.registerCustomEditor(Date.class, new ApplicationDateParser());
	}

	public ModelAndView handleException(HttpServletRequest request,
			HttpServletResponse response, Throwable throwable) {

		ApplicationContext applicationContext = super.getApplicationContext();
		ExceptionForm exceptionForm = applicationContext
				.getBean(ExceptionForm.class);
		exceptionForm.setThrowable(throwable);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("exceptionView");
		modelAndView.addObject(DEFAULT_COMMAND_NAME, exceptionForm);

		return modelAndView;
	}
	
}
