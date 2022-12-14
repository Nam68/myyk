package myyk.backend.controller.global;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import myyk.backend.controller.BaseController;
import myyk.util.annotation.ServiceFunction;
import myyk.util.cookie.CookieName;
import myyk.util.cookie.CookieTool;
import myyk.util.enumeration.Languages;
import myyk.util.exception.SystemException;

@Controller
@ServiceFunction
public class LanguageSettingPageController extends BaseController {

	@RequestMapping("/globalPage/languageSettingPage.do")
	public String show() {
		return "/globalPage/languageSetting";
	}

	@RequestMapping("/globalPage/languageSetting.do")
	public String execute(String lang, HttpServletResponse response) throws SystemException {
		
		if(!Languages.exists(lang)) {
			throw new SystemException("This Language is not available");
		}
		
		CookieTool.makeCookie(CookieName.APPOINTED_LANGUAGE, lang, CookieTool.COOKIE_MONTH_30, response);
		return "redirect:/globalPage/topPage.do";
	}
}
