package myyk.util.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import myyk.backend.BaseController;
import myyk.util.CookieTool;

public class SkipTopPageInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		String skip = CookieTool.getCookieValue(BaseController.SKIP_TOP_PAGE, request);
		
		if("".equals(skip)) {
			return true;
		} else {
			response.sendRedirect(request.getContextPath() + "/homePage.do");
		}
		
		return false;
	}
	
}
