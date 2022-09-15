package myyk.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import myyk.backend.domain.MemberEntity;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {

	MemberEntity findByEmail(String email);
	
}
