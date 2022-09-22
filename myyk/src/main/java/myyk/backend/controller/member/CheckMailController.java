package myyk.backend.controller.member;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import myyk.backend.controller.BaseController;
import myyk.backend.dto.member.CreateMemberDto;
import myyk.util.annotation.ServiceFunction;
import myyk.util.cookie.CookieName;
import myyk.util.cookie.CookieTool;
import myyk.util.enumeration.Region;
import myyk.util.enumeration.Result;
import myyk.util.enumeration.ServiceCategory;
import myyk.util.exception.SystemException;

@Controller
@ServiceFunction(ServiceCategory.MEMBER)
@RequestMapping("/memberPage")
public class CheckMailController extends BaseController {

	@RequestMapping("/checkEmailInput.do")
	public String input() {
		return "/memberPage/checkEmail";
	}
	
	@RequestMapping(path = "/checkEmail.do", method = RequestMethod.POST)
	public String execute(CreateMemberDto dto, HttpServletRequest request) throws SystemException {
		
		String language = CookieTool.getCookieValue(CookieName.CLIENT_LANGUAGE, request);
		
		getLogicManager().getMemberService().checkEmail(dto, Region.getRegion(language));
				
		return "/memberPage/checkEmailComplete";
	}
	
}
