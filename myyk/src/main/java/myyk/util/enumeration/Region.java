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
}
