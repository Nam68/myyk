package myyk.util.enumeration;

/**
 * <p>회원이 설정한 국가에 대한 이넘</p>
 */
public enum Region implements EnumInterface {

	KOREA("korean"),
	
	JAPAN("japanese"),
	
	;
	
	private String value;
	
	Region(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	public static Region getRegion(String language) {
		
		if("ko".equals(language)) {
			return KOREA;
		} else if("ja".equals(language)) {
			return JAPAN;
		} else if("jp".equals(language)) {
			return JAPAN;
		} else {
			return KOREA;
		}
	}
}
