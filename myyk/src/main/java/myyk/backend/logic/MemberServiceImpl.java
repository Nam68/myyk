package myyk.backend.logic;

import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import myyk.backend.dto.member.CreateMemberDto;
import myyk.backend.domain.MemberEntity;
import myyk.backend.service.MemberService;
import myyk.util.enumeration.Result;
import myyk.util.exception.SystemException;
import myyk.util.mail.MailSenderFactory;

@Service
@EnableJpaAuditing
@Transactional(readOnly = true)
public class MemberServiceImpl extends BaseLogic implements MemberService {
	
	@Transactional
	@Override
	public Result create(CreateMemberDto dto) throws SystemException {
		
		MemberEntity memberEntity = new MemberEntity(
				dto.getPassword(),
				dto.getUpperEmail(),
				dto.getLowerEmail(),
				dto.getNickname(),
				dto.getRegion()
			);
		
		getRepositoryManager().getMemberRepository().saveAndFlush(memberEntity);
		
		return null;
	}

	@Override
	public Result checkEmail(CreateMemberDto dto) throws SystemException {
		
		return MailSenderFactory.getMailSender()
			.setFrom("test@test.test")
			.setTo(getEmail(dto.getUpperEmail(), dto.getLowerEmail()))
			.setSubject("test")
			.setHtml(true)
			.setContent("<h1>test</h1><div>hello<a href=\"https://www.naver.com\">test</a></div>" + createVariable(40, null))
			.send();
		
	}
	

}
