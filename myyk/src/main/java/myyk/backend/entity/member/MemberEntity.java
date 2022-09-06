package myyk.backend.entity.member;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.NaturalId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import myyk.util.BaseApp;
import myyk.util.enumeration.MemberType;
import myyk.util.enumeration.Region;
import myyk.util.exception.SystemException;

/**
 * <p>회원 엔티티.</p>
 */
@Entity
@Table(name = "MEMBER_TBL")
public class MemberEntity extends BaseApp {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MEMBER_IDX")
	private Long idx;
	
	@NaturalId
	@Column(name = "MEMBER_ID")
	private String id;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "PASSWORD_SALT")
	private String passwordSalt;
	
	@Column(name = "UPPER_EMAIL")
	private String upperEmail;
	
	@Column(name = "LOWER_EMAIL")
	private String lowerEmail;
	
	@Column(name = "NICKNAME")
	private String nickname;
	
	@Column(name = "REGION")
	private Region region;
	
	@Column(name = "MEMBER_TYPE")
	private MemberType memberType;
	
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private LocalDateTime registeredDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private LocalDateTime modifiedDate;

	/**
	 * <p>회원 엔티티를 구축한다.</p>
	 * 
	 * @param id 아이디
	 * @param password 비밀번호
	 * @param email 이메일
	 * @param region 지역
	 * @throws SystemException 시스템 예외
	 */
	public MemberEntity(
			String id, 
			String password, 
			String email,
			String nickname,
			Region region) throws SystemException {
		
		this.id = id;
		generatePassword(password);
		setEmail(email);
		this.nickname = nickname;
		this.region = region;
		this.memberType = MemberType.TMP_MEMBER;
	}
	
	/**
	 * <p>idx를 반환한다.</p>
	 * 
	 * @return idx
	 */
	public Optional<Long> getIdx() {
		return Optional.of(idx);
	}
	
	/**
	 * <p>id를 반환한다.</p>
	 * 
	 * @return id
	 */
	public Optional<String> getId() {
		return Optional.of(id);
	}
	
	/**
	 * <p>이메일을 반환한다.</p>
	 * 
	 * @return 이메일
	 * @throws SystemException 시스템 예외
	 */
	public Optional<String> getEmail() throws SystemException {
		String email = decrypt(upperEmail) + "@" + lowerEmail;
		return Optional.of(email);
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
	 * <p>등록시각을 반환한다.</p>
	 * 
	 * @return 등록시각
	 */
	public LocalDateTime getRegisterdDate() {
		return registeredDate;
	}
	
	/**
	 * <p>갱신시각을 반환한다.</p>
	 * 
	 * @return 갱신시각
	 */
	public LocalDateTime getModifiedDate() {
		return modifiedDate;
	}
	
	/**
	 * <p>이메일을 설정한다.</p>
	 * 
	 * @param email 이메일
	 * @throws SystemException 시스템 예외
	 */
	public void setEmail(String email) throws SystemException {
		String[] splitedEmail = email.split("@");
		this.upperEmail = encrypt(splitedEmail[0]);
		this.lowerEmail = splitedEmail[1];
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
	private void generatePassword(String password) 
			throws SystemException {
		this.passwordSalt = createSalt();
		this.password = doHashing(password, passwordSalt);
	}
}
