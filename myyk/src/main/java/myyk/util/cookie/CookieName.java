package myyk.util.cookie;

public class CookieName {


	/**
	 * <p>탑 페이지를 스킵할지 여부에 대해 가지고 있는 쿠키.</p>
	 */
	public static final String SKIP_TOP_PAGE = "skipTopPage";
	
	/**
	 * <p>헤더에 있는 기능 중 어떤 기능에 속해있는지에 대한 정보를 가지고 있는 쿠키의 이름.</p>
	 * <p>{@link ServiceFunction}에서 부여된 값이 {@link ServiceFunctionInterceptor}를 통해 자동으로 세팅된다.</p>
	 */
	public static final String HEADER = "header";
	
	/**
	 * <p>현재 클라이언트에 지정되어 있는 언어 정보를 가지고 있는 쿠키의 이름.</p>
	 * <p>시스템에 의해 생성된다.</p>
	 */
	public static final String CLIENT_LANGUAGE = "client_language";
	
	/**
	 * <p>사용자가 직접 지정한 언어 정보를 가지고 있는 쿠키의 이름.</p>
	 * <p>이 쿠키가 존재하지 않는 경우, 사용자로부터 언어 설정을 강제한다.</p>
	 */
	public static final String APPOINTED_LANGUAGE = "appointed_language";
	
}
