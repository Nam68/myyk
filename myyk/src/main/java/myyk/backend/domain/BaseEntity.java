package myyk.backend.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import myyk.util.BaseApp;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity extends BaseApp {

	@Column(name = "REGISTERED_DATE")
	@CreatedDate
	private LocalDateTime registeredDate;
	
	@Column(name = "MODIFIED_DATE")
	@LastModifiedDate
	private LocalDateTime modifiedDate;
	
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
}
