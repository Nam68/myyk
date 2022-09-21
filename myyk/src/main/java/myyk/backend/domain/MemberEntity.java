package myyk.backend.domain;

import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

import myyk.util.enumeration.MemberType;
import myyk.util.enumeration.Region;
import myyk.util.exception.SystemException;

/**
 * <p>회원 엔티티.</p>
 */
@Entity
@Table(name = "MEMBER_TBL")
public class MemberEntity extends BaseEntity {
	
	/**
	 * <p>솔트값의 길이.</p>
	 */
	private static final int SALT_SIZE = 16;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MEMBER_IDX")
	private Long idx;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "PASSWORD_SALT")
	private String passwordSalt;
	
	@NaturalId
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "UPPER_EMAIL")
	private String upperEmail;
	
	@Column(name = "LOWER_EMAIL")
	private String lowerEmail;
	
	@Column(name = "NICKNAME")
	private String nickname;
	
	@Column(name = "REGION")
	@Enumerated(EnumType.STRING)
	private Region region;
	
	@Column(name = "MEMBER_TYPE")
	@Enumerated(EnumType.STRING)
	private MemberType memberType;

	@Deprecated
	protected MemberEntity() {
		// TODO Auto-generated constructor stub
	}
	
	public MemberEntity(
			String password,
			String upperEmail, 
			String lowerEmail, 
			String nickname, 
			Region region) throws SystemException {
		generatePassword(password);
		setEmail(upperEmail, lowerEmail);
		this.nickname = nickname;
		this.region = region;
		this.memberType = MemberType.TMP_MEMBER;
	}

	/**
	 * <p>idx를 반환한다.</p>
	 * 
	 * @return idx
	 */
	public Long getIdx() {
		return idx;
	}
	
	/**
	 * <p>이메일을 반환한다.</p>
	 * 
	 * @return 이메일
	 * @throws SystemException 시스템 예외
	 */
	public Optional<String> getEmail() throws SystemException {
		return Optional.of(decrypt(email));
	}
	
	/**
	 * <p>닉네임을 반환한다.</p>
	 * 
	 * @return 닉네임
	 */
	public Optional<String> getNickname() {
		return Optional.of(nickname);
	}

	/**
	 * <p>지역을 반환한다.</p>
	 * 
	 * @return 지역
	 * @throws SystemException 시스템 예외 
	 */
	public Optional<Region> getRegion() {
		return Optional.of(region);
	}
	
	/**
	 * <p>회원타입을 반환한다.</p>
	 * 
	 * @return 회원타입
	 */
	public Optional<MemberType> getMemberType() {
		return Optional.of(memberType);
	}
	
	/**
	 * <p>이메일을 설정한다.</p>
	 * 
	 * @param email 이메일
	 * @throws SystemException 시스템 예외
	 */
	public void setEmail(String upperEmail, String lowerEmail) throws SystemException {
		this.upperEmail = encrypt(upperEmail);
		this.lowerEmail = lowerEmail;
		this.email = encrypt(getEmail(upperEmail, lowerEmail));
	}
	
	/**
	 * <p>닉네임을 설정한다.</p>
	 * 
	 * @param nickname 닉네임
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	/**
	 * <p>지역을 설정한다.</p>
	 * 
	 * @param region 지역
	 */
	public void setRegion(Region region) {
		this.region = region;
	}
	
	/**
	 * <p>회원 타입을 설정한다.</p>
	 * 
	 * @param memberType 회원타입
	 */
	public void setMemberType(MemberType memberType) {
		this.memberType = memberType;
	}
	
	// 솔트를 생성해서 비밀번호를 설정한다.
	private void generatePassword(String password) throws SystemException {
		this.passwordSalt = createVariable(SALT_SIZE, null);
		this.password = doHashing(password, passwordSalt);
	}
}

