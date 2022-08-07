package myyk.util.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import myyk.backend.BaseController;
import myyk.util.annotation.ServiceFunction;

public class ServiceFunctionInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HandlerMethod handlerMethod = (HandlerMethod) handler;  
		
		ServiceFunction function = handlerMethod.getBeanType().getAnnotation(ServiceFunction.class);
		
		request.setAttribute(BaseController.HEADER, function.value().toString());
		
		return super.preHandle(request, response, handler);
	}
	
}
