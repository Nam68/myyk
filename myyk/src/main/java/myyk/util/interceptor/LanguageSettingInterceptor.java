package myyk.util.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import myyk.util.cookie.CookieName;
import myyk.util.cookie.CookieTool;

import myyk.util.enumeration.Languages;
import myyk.util.exception.SystemException;

/**
 * <p>사용자가 설정한 언어가 존재하지 않는 경우 언어 선택 창으로 이동.</p>
 */
public class LanguageSettingInterceptor extends HandlerInterceptorAdapter {

	private static final String LANGUAGE_SETTING_PAGE = "/myyk/globalPage/languageSettingPage.do";
	private static final String SET_LANGUAGE_PATH = "/myyk/globalPage/languageSetting.do";
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		//
		// 사용자가 설정한 언어 설정값이 없는 경우 설정 화면으로 리다이렉트
		// 설정값이 존재하는 경우 시스템 쿠키 정보와 동기화
		//
		String language = CookieTool.getCookieValue(CookieName.APPOINTED_LANGUAGE, request);
		if(language == null || language.isEmpty()) {
			if(request.getRequestURI().equals(LANGUAGE_SETTING_PAGE)) {
				return true;
			}
			if(request.getRequestURI().equals(SET_LANGUAGE_PATH)) {
				return true;
			}
			response.sendRedirect("/myyk/globalPage/languageSettingPage.do");
			return false;
		}
		
		if(!Languages.exists(language)) {
			throw new SystemException("Missing Language Enumeration");
		}
		
		//
		// 시스템에서 생성되는 클라이언트 언어 정보 쿠키가 없는 경우 설정 화면으로 이동
		//
		String clientLanguage = CookieTool.getCookieValue(CookieName.CLIENT_LANGUAGE, request);
		
		if(clientLanguage == null || clientLanguage.isEmpty()) {
			response.sendRedirect("/myyk/globalPage/languageSettingPage.do");
			return false;
		}
		
		//
		// 쿠키 정보 동기화
		// 
		//
		if(!clientLanguage.equals(language)) {
			CookieTool.modifyCookie(CookieName.APPOINTED_LANGUAGE, clientLanguage, request, response);
		}
		
		return true;
	}
	
}
