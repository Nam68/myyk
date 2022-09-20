package myyk.backend.controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import myyk.backend.controller.BaseController;
import myyk.backend.dto.member.CreateMemberDto;
import myyk.backend.service.MemberService;
import myyk.util.annotation.ServiceFunction;
import myyk.util.annotation.SetEnums;
import myyk.util.enumeration.Region;
import myyk.util.enumeration.ServiceCategory;
import myyk.util.exception.SystemException;

@Controller
@ServiceFunction(ServiceCategory.MEMBER)
@RequestMapping("/memberPage")
public class CreateMemberController extends BaseController {
	
	@RequestMapping("/createMemberInput.do")
	@SetEnums(values = {Region.class})
	public String input() {
		return "/memberPage/createMember";
	}
	
	@RequestMapping(path = "/createMember.do", method = RequestMethod.POST)
	public String execute(CreateMemberDto memberDto) throws SystemException {
		getLogicManager().getMemberService().create(memberDto);
		return "redirect:/globalPage/homePage.do";
	}
	
	@RequestMapping(path = "/checkEmailDuplication.do", method = RequestMethod.POST)
	@ResponseBody
	public String checkEmail(CreateMemberDto memberDto) throws SystemException {
		return getLogicManager().getMemberService().checkEmail(memberDto).toString();
	}
	
}
