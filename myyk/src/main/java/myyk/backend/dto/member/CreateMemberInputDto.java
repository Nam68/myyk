package myyk.backend.dto.member;

import myyk.util.enumeration.Region;

/**
 * <p>회원가입 입력창에 대한 DTO.</p>
 */
public class CreateMemberInputDto {

	private String password = "";
	
	private String nickname = "";
	
	private String upperEmail = "";
	
	private String lowerEmail = "";
	
	private Region region;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getUpperEmail() {
		return upperEmail;
	}

	public void setUpperEmail(String upperEmail) {
		this.upperEmail = upperEmail;
	}

	public String getLowerEmail() {
		return lowerEmail;
	}

	public void setLowerEmail(String lowerEmail) {
		this.lowerEmail = lowerEmail;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}
	
}
