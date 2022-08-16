package myyk.backend.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import myyk.backend.BaseController;
import myyk.util.annotation.ServiceFunction;
import myyk.util.cookie.CookieName;
import myyk.util.cookie.CookieTool;

@Controller
@ServiceFunction
public class LanguageSettingPageController extends BaseController {

	@RequestMapping("/globalPage/languageSettingPage.do")
	public String show() {
		return "/globalPage/languageSetting";
	}

	@RequestMapping("/globalPage/languageSetting.do")
	public String execute(String lang, HttpServletResponse response) {
		CookieTool.makeCookie(CookieName.APPOINTED_LANGUAGE, lang, CookieTool.COOKIE_MONTH_30, response);
		return "/globalPage/languageSetting";
	}
}
