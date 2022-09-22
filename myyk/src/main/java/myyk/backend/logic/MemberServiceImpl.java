package myyk.backend.logic;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import myyk.backend.dto.member.CreateMemberDto;
import myyk.backend.repository.TmpMemberRepository;
import myyk.backend.domain.MemberEntity;
import myyk.backend.domain.TmpMemberEntity;
import myyk.backend.service.MemberService;
import myyk.util.enumeration.Region;
import myyk.util.enumeration.Result;
import myyk.util.exception.SystemException;
import myyk.util.mail.MailSenderFactory;
import myyk.util.mail.MailTemplate;

@Service
@EnableJpaAuditing
@Transactional(readOnly = true)
public class MemberServiceImpl extends BaseLogic implements MemberService {
	
	@Transactional
	@Override
	public Result create(CreateMemberDto dto) throws SystemException {
		
		MemberEntity memberEntity = new MemberEntity(
				dto.getPassword(),
				dto.getLocalPartEmail(),
				dto.getDomainPartEmail(),
				dto.getNickname(),
				dto.getRegion()
			);
		
		getRepositoryManager().getMemberRepository().saveAndFlush(memberEntity);
		
		return null;
	}

	@Transactional
	@Override
	public Result checkEmail(CreateMemberDto dto, Region region) throws SystemException {

		TmpMemberRepository repository = getRepositoryManager().getTmpMemberRepository();
		
		int mailCount = repository.findByEmailAndRegisteredDateAfter(
							getEncryptedEmail(dto.getLocalPartEmail(), dto.getDomainPartEmail()), 
							LocalDateTime.now().minusHours(1)).size();
		if(mailCount >= 5) {
			return Result.SUCCESS;
		}
		
		String subject = null;
		String title = null;
		String info = null;
		String code = createVariable(40, null);
		
		if(region == Region.KOREA) {
			subject = MailTemplate.CHECK_EMAIL_SUBJECT_KO;
			title = MailTemplate.CHECK_EMAIL_TITLE_KO;
			info = MailTemplate.CHECK_EMAIL_INFO_KO;
		} else if(region == Region.JAPAN) {
			subject = MailTemplate.CHECK_EMAIL_SUBJECT_JA;
			title = MailTemplate.CHECK_EMAIL_TITLE_JA;
			info = MailTemplate.CHECK_EMAIL_INFO_JA;
		} else {
			subject = MailTemplate.CHECK_EMAIL_SUBJECT_KO;
			title = MailTemplate.CHECK_EMAIL_TITLE_KO;
			info = MailTemplate.CHECK_EMAIL_INFO_KO;
		}
		
		Result result = MailSenderFactory.getMailSender()
				.setTo(getEmail(dto.getLocalPartEmail(), dto.getDomainPartEmail()))
				.setSubject(subject)
				.setHtml(true)
				.setContent(String.format(
						MailTemplate.getHtml(MailTemplate.CHECK_EMAIL), 
						title, 
						info,
						code,
						code))
				.send();
		
		if (result != Result.ERROR) {
			TmpMemberEntity entity = 
					new TmpMemberEntity(code, dto.getLocalPartEmail(), dto.getDomainPartEmail());
			repository.saveAndFlush(entity);
		}
		
		return result;
	}
	
	@Override
	public Result checkEmailCode(String code) throws SystemException {
		
		TmpMemberRepository repository = getRepositoryManager().getTmpMemberRepository();
		
		if(repository.findByTmpCodeAndRegisteredDateAfter(code, LocalDateTime.now().minusMinutes(15)) == null) {
			return Result.ERROR;
		}
		return Result.SUCCESS;
	}

}
