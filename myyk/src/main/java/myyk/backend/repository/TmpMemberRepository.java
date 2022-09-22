package myyk.backend.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import myyk.backend.domain.TmpMemberEntity;

@Repository
public interface TmpMemberRepository extends JpaRepository<TmpMemberEntity, Long> {

	/**
	 * <p>디도스 방지를 위한 메일 횟수 제한</p>
	 * 
	 * @param email 이메일
	 * @param limitTime 현재시각 한 시간 전
	 * @return 같은 이메일로 등록된 임시회원
	 */
	List<TmpMemberEntity> findByEmailAndRegisteredDateAfter(String email, LocalDateTime limitTime);
	
	/**
	 * <p>메일 인증 확인.</p>
	 * 
	 * @param tmpCode 메일로 보낸 코드
	 * @param expirationTime 현재시각으로부터 15분 전
	 * @return 유효한 임시회원
	 */
	TmpMemberEntity findByTmpCodeAndRegisteredDateAfter(String tmpCode, LocalDateTime expirationTime);
	
}
