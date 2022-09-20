package myyk.backend.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import myyk.backend.dto.member.CreateMemberDto;
import myyk.backend.repository.MemberRepository;
import myyk.backend.domain.MemberEntity;
import myyk.backend.service.MemberService;
import myyk.util.enumeration.Result;
import myyk.util.exception.SystemException;

@Service
@EnableJpaAuditing
@Transactional(readOnly = true)
public class MemberLogic extends BaseLogic implements MemberService {

	@Autowired
	private MemberRepository memberRepository;
	
	@Transactional
	@Override
	public Result create(CreateMemberDto memberDto) throws SystemException {
		
		MemberEntity memberEntity = new MemberEntity(
				memberDto.getPassword(),
				memberDto.getUpperEmail(),
				memberDto.getLowerEmail(),
				memberDto.getNickname(),
				memberDto.getRegion()
				);
		
		memberRepository.saveAndFlush(memberEntity);
		
		return null;
	}

	@Override
	public Result checkEmail(CreateMemberDto memberDto) throws SystemException {
		
		String email = getEncryptedEmail(memberDto.getUpperEmail(), memberDto.getLowerEmail());
		MemberEntity member = memberRepository.findByEmail(email);
		
		if(member != null) {
			return Result.ERROR;
		}
		return Result.SUCCESS;
	}
	

}
