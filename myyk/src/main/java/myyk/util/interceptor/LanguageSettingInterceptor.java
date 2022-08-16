package myyk.util.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import myyk.backend.BaseController;
import myyk.util.CookieTool;

/**
 * 
 */
public class LanguageSettingInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		String clientLanguage = CookieTool.getCookieValue(BaseController.CLIENT_LANGUAGE, request);
		if(clientLanguage == null || clientLanguage.isEmpty()) {
			
		}
		
		String language = CookieTool.getCookieValue("languageSetting", request);
		
//		if(language)
		
		return super.preHandle(request, response, handler);
	}
	
}
