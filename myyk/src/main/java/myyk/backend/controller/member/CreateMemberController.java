package myyk.backend.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import myyk.backend.controller.BaseController;
import myyk.backend.dto.member.CreateMemberDto;
import myyk.util.annotation.ServiceFunction;
import myyk.util.annotation.SetEnums;
import myyk.util.enumeration.Region;
import myyk.util.enumeration.Result;
import myyk.util.enumeration.ServiceCategory;
import myyk.util.exception.SystemException;
import myyk.util.mail.MailSenderFactory;

@Controller
@ServiceFunction(ServiceCategory.MEMBER)
@RequestMapping("/memberPage")
public class CreateMemberController extends BaseController {
	
	@RequestMapping("/createMemberInput.do")
	@SetEnums(values = {Region.class})
	public String input(String code) throws SystemException {
		if(getLogicManager().getMemberService().checkEmailCode(code) == Result.ERROR) {
			return "/memberPage/checkEmailFailed";
		}
		return "/memberPage/createMember";
	}
	
	@RequestMapping(path = "/createMember.do", method = RequestMethod.POST)
	public String execute(CreateMemberDto memberDto) throws SystemException {
		getLogicManager().getMemberService().create(memberDto);
		return "redirect:/globalPage/homePage.do";
	}
	
	@RequestMapping(path = "/checkEmailExists.do", method = RequestMethod.POST)
	@ResponseBody
	public String checkEmailExists(CreateMemberDto memberDto) throws SystemException {
		return MailSenderFactory.getMailSender()
			.setTo("epoche02@naver.com")
			.setSubject("test")
			.setContent("hi")
			.send().toString();
		
		// 이메일 확인 추가
	}
	
}
