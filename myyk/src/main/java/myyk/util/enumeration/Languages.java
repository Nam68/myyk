package myyk.util.enumeration;

public enum Languages {

	KOREAN("ko"),
	
	JAPANES("ja"),
	
	DEFAULT(Languages.KOREAN.getLangugage())
	;
	
	
	private String language;
	
	private Languages(String language) {
		this.language = language;
	}
	
	public String getLangugage() {
		return language;
	}
	
	public static boolean exists(String language) {
		
		for(Languages target : Languages.values()) {
			if(target.getLangugage().equals(language)) {
				return true;
			}
		}
		return false;
	}
	
}
