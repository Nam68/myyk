package myyk.backend.controller;

import myyk.util.BaseApp;
import myyk.util.exception.SystemException;

public class BaseController extends BaseApp {

	public static final String MESSAGES = "messages";
	
	//이넘을 넣으면 자동으로 리스트화해서 홀드에 입력.
	public static void addEnumListIntoHolder(Class<?> target) throws SystemException {
		Object[] enumValues = target.getEnumConstants();
		
		if(enumValues == null) {
			throw new SystemException("this class is not enum");
		}
		
		for (Object value : enumValues) {
			
		}
	}
	
}
