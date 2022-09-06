package myyk.backend.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import myyk.backend.controller.BaseController;
import myyk.backend.entity.member.MemberEntity;
import myyk.util.annotation.ServiceFunction;
import myyk.util.enumeration.ServiceCategory;
import myyk.util.exception.SystemException;

@Controller
@ServiceFunction(ServiceCategory.MEMBER)
@RequestMapping("/memberPage")
public class CreateMemberController extends BaseController {

	@RequestMapping("/createMemberInput.do")
	public String input() {
		return "/memberPage/createMember";
	}
	
	@RequestMapping(path = "/createMember.do", method = RequestMethod.POST)
	public String execute(MemberEntity member) throws SystemException {
		

		return "redirect:/globalPage/homePage.do";
	}
	
}
