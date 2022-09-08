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
import myyk.util.BaseApp;
import myyk.util.annotation.SetEnums;
import myyk.util.enumeration.EnumInterface;

/**
 * <p>컨트롤러에서 이넘을 입력하면 입력된 이넘의 값들을 리스트로 반환한다.</p>
 */
public class SetEnumsInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		
		SetEnums setEnums = handlerMethod.getMethod().getAnnotation(SetEnums.class);
		if (setEnums == null) {
			return true;
		}
		
		Map<String, List<Map<String, String>>> allEnumMap = new HashMap<>();
		request.setAttribute(BaseController.ENUMS, allEnumMap);
		
		Class<?>[] classes = setEnums.values();
		
		for (Class<?> target : classes) {
			Object[] enums = target.getEnumConstants();
			if (enums == null || enums.length == 0) {
				break;
			}
			
			List<Map<String, String>> valueList = new ArrayList<>();
			for (Object obj : enums) {
				if(!(obj instanceof EnumInterface)) {
					break;
				}
				EnumInterface ei = (EnumInterface) obj;
				
				Map<String, String> valueMap = new HashMap<>();
				valueMap.put(BaseController.ENUM_NAME, ei.toString());
				valueMap.put(BaseController.ENUM_VALUE, ei.getValue());
				
				valueList.add(valueMap);
			}
			
			allEnumMap.put(BaseApp.toCamelCase(target.getSimpleName()), valueList);
		}
		
		return true;
	}
	
}
