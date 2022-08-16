package myyk.util.cookie;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>쿠키 관련 기능을 일괄적으로 제공</p>
 */
public class CookieTool {

	// 초를 날짜로 환산
	private static final int SECOND_TO_DATE = 60*60*24;
	
	/**
	 * <p>쿠키 시간 값 : 하루</p>
	 */
	public static final int COOKIE_DAY = SECOND_TO_DATE;
	
	/**
	 * <p>쿠키 시간 값 : 일주일</p>
	 */
	public static final int COOKIE_WEEK = COOKIE_DAY * 7;
	
	/**
	 * <p>쿠키 시간 값 : 28일(2월)</p>
	 */
	public static final int COOKIE_MONTH_28 = COOKIE_DAY * 28;
	
	/**
	 * <p>쿠키 시간 값 : 29일(윤달)</p>
	 */
	public static final int COOKIE_MONTH_29 = COOKIE_DAY * 29;
	
	/**
	 * <p>쿠키 시간 값 : 30일(1달값으로는 디폴트)</p>
	 */
	public static final int COOKIE_MONTH_30 = COOKIE_DAY * 30;
	
	/**
	 * <p>쿠키 시간 값 : 31일</p>
	 */
	public static final int COOKIE_MONTH_31 = COOKIE_DAY * 31;
	
	/**
	 * <p>쿠키 시간 값 : 1년</p>
	 */
	public static final int COOKIE_YEAR = COOKIE_DAY * 365;
	
	// 쿠키 기본값
	private static final int DEFAULT_MAX_AGE = COOKIE_DAY;
	
	/**
	 * <p>쿠키를 생성한다.</p>
	 * 
	 * @param name 쿠키 이름
	 * @param value 쿠키값
	 * @param response 리스폰스
	 */
	public static void makeCookie(String name, String value, HttpServletResponse response) {
		makeCookie(name, value, "/", DEFAULT_MAX_AGE, response);
	}
	
	/**
	 * <p>쿠키를 생성한다.</p>
	 * 
	 * @param name 쿠키 이름
	 * @param value 쿠키값
	 * @param path 쿠키경로
	 * @param response 리스폰스
	 */
	public static void makeCookie(String name, String value, String path, HttpServletResponse response) {
		makeCookie(name, value, path, DEFAULT_MAX_AGE, response);
	}
	
	/**
	 * <p>쿠키를 생성한다.</p>
	 * 
	 * @param name 쿠키 이름
	 * @param value 쿠키값
	 * @param maxAge 쿠키 생존시간
	 * @param response 리스폰스
	 */
	public static void makeCookie(String name, String value, int maxAge, HttpServletResponse response) {
		makeCookie(name, value, "/", maxAge, response);
	}
	
	/**
	 * <p>쿠키를 생성한다.</p>
	 * 
	 * @param name 쿠키 이름
	 * @param value 쿠키값
	 * @param days 쿠키 생존날짜
	 * @param response 리스폰스
	 */
	public static void makeCookieForDate(String name, String value, int days, HttpServletResponse response) {
		makeCookieForDate(name, value, "/", days, response);
	}
	
	/**
	 * <p>쿠키를 생성한다.</p>
	 * 
	 * @param name 쿠키 이름
	 * @param value 쿠키값
	 * @param path 쿠키 경로
	 * @param days 쿠키 생존날짜
	 * @param response 리스폰스
	 */
	public static void makeCookieForDate(String name, String value, String path, int days, HttpServletResponse response) {
		makeCookie(name, value, path, days*SECOND_TO_DATE, response);
	}
	
	/**
	 * <p>쿠키를 생성한다.</p>
	 * 
	 * @param name 쿠키 이름
	 * @param value 쿠키값
	 * @param path 쿠키 경로
	 * @param maxAge 쿠키 생존시간
	 * @param response 리스폰스
	 */
	public static void makeCookie(String name, String value, String path, int maxAge, HttpServletResponse response) {
		
		Cookie cookie = new Cookie(name, value);
		cookie.setPath(path);
		cookie.setMaxAge(maxAge);
		
		response.addCookie(cookie);
	}
	
	/**
	 * <p>쿠키를 삭제한다.</p>
	 * 
	 * @param name 쿠키 이름
	 * @param request 리퀘스트
	 */
	public static void deleteCookie(String name, HttpServletRequest request) {

		Cookie[] cookies = request.getCookies();
		
		for(Cookie cookie : cookies) {
			if(cookie.getName().equals(name)) {
				cookie.setMaxAge(-1);
			}
		}
	}
	
	/**
	 * <p>리퀘스트의 모든 쿠키를 삭제한다.</p>
	 * 
	 * @param request 리퀘스트
	 */
	public static void clear(HttpServletRequest request) {
		
		Cookie[] cookies = request.getCookies();
		
		for(Cookie cookie : cookies) {
			cookie.setMaxAge(-1);
		}
	}
	
	/**
	 * <p>쿠기의 이름을 통해 쿠기를 찾는다.</p>
	 * <P>해당 이름의 쿠기가 없는 경우 빈 문자열을 반환하므로, 리턴값은 어떠한 경우에도 null이 되지 않는다.</p>
	 * 
	 * @param name 쿠키의 이름
	 * @param request 리퀘스트
	 * @return 쿠키값
	 */
	public static String getCookieValue(String name, HttpServletRequest request) {
		
		Cookie[] cookies = request.getCookies();
		
		if(cookies == null) {
			return "";
		}
		
		for(Cookie cookie : cookies) {
			if(cookie.getName().equals(name)) {
				if(cookie.getMaxAge() > 0) {
					return cookie.getValue();
				}
			}
		}
		
		return "";
	}
	
}

