package myyk.backend.domain;

import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

import myyk.util.exception.SystemException;

/**
 * <p>임시회원 엔티티.</p>
 */
@Entity
@Table(name = "TMP_MEMBER_TBL")
public class TmpMemberEntity extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TMP_MEMBER_IDX")
	private long tmpMemberIdx;
	
	@NaturalId
	@Column(name = "TMP_CODE")
	private String tmpCode;
	
	@Column(name = "EMAIL")
	private String email;	
	
	public TmpMemberEntity(
			String tmpCode, 
			String localPartEmail, 
			String domainPartEmail) throws SystemException {
		this.tmpCode = tmpCode;
		this.email = getEncryptedEmail(localPartEmail, domainPartEmail);
	}
	
	@Deprecated
	public TmpMemberEntity() {
		// TODO Auto-generated constructor stub
	}
	
	public long getTmpMemberIdx() {
		return tmpMemberIdx;
	}
	
	public Optional<String> getTmpCode() {
		return Optional.of(tmpCode);
	}
	
	public void setTmpCode(String tmpCode) {
		this.tmpCode = tmpCode;
	}
	
	public Optional<String> getEmail() throws SystemException {
		return Optional.of(getDecryptedEmial(email));
	}
}
