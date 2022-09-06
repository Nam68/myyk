package myyk.util.interceptor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import myyk.backend.controller.BaseController;
import myyk.util.annotation.SetEnums;

/**
 * <p>컨트롤러에서 이넘을 입력하면 입력된 이넘의 값들을 리스트로 반환한다.</p>
 */
public class SetEnumsInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		
		SetEnums setEnums = handlerMethod.getMethod().getAnnotation(SetEnums.class);
		
		Map<String, List<String>> map = new HashMap<>();
		request.setAttribute(BaseController.ENUMS, map);
		
		Class<?>[] classes = setEnums.values();
		
		for (Class<?> target : classes) {
			Object[] enums = target.getEnumConstants();
			if (enums == null || enums.length == 0) {
				break;
			}
			
			List<String> list = new ArrayList<>();
			for (Object obj : enums) {
				list.add(obj.toString());
			}
			map.put(target.getSimpleName(), list);
		}
		
		return true;
	}
	
}
