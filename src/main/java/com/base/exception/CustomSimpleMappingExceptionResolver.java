package com.base.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

public class CustomSimpleMappingExceptionResolver extends
		SimpleMappingExceptionResolver {

	@Override
	protected ModelAndView doResolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		// Expose ModelAndView for chosen error view.
		String viewName = determineViewName(ex, request);
		logger.info(viewName);
		if (viewName != null) {
			if (request.getHeader("X-Requested-With") != null
					&& request.getHeader("X-Requested-With").indexOf(
							"XMLHttpRequest") > -1) {// JSON格式返回
				logger.error("ajax request error", ex);
				response.setStatus(500);
				return getModelAndView(viewName, ex, request);
			} else {
				Integer statusCode = determineStatusCode(request, viewName);
				if (statusCode != null) {
					applyStatusCodeIfPossible(request, response, statusCode);
				}
				logger.error(viewName, ex);
				return getModelAndView(viewName, ex, request);
			}
		} else {
			return null;
		}
	}
}
