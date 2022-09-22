package myyk.backend.dto.member;

import myyk.util.enumeration.Region;

/**
 * <p>회원가입 입력창에 대한 DTO.</p>
 */
public class CreateMemberDto {

	private String password = "";
	
	private String nickname = "";
	
	private String localPartEmail = "";
	
	private String domainPartEmail = "";
	
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

	public String getLocalPartEmail() {
		return localPartEmail;
	}

	public void setLocalPartEmail(String localPartEmail) {
		this.localPartEmail = localPartEmail;
	}

	public String getDomainPartEmail() {
		return domainPartEmail;
	}

	public void setDomainPartEmail(String domainPartEmail) {
		this.domainPartEmail = domainPartEmail;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}
	
}
