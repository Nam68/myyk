package myyk.backend.controller;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import myyk.backend.BaseController;
import myyk.util.CookieTool;
import myyk.util.annotation.ServiceFunction;

@Controller
@ServiceFunction
public class TopPageController extends BaseController {

	@RequestMapping("/globalPage/topPage.do")
	public String show(HttpSession session) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		long period = System.currentTimeMillis() - sdf.parse("2018-09-16").getTime();
		
		DecimalFormat df = new DecimalFormat("###,###");
		session.setAttribute("period", df.format(period/1000/60/60/24));
		
		return "/globalPage/topPage";
	}
	
	@RequestMapping(path = "/globalPage/skipTopPage.do", method = RequestMethod.POST)
	public String execute(HttpServletResponse response) {
		CookieTool.makeCookie(SKIP_TOP_PAGE, "true", CookieTool.COOKIE_WEEK, response);
		return "/globalPage/homePage";
	}
	
}
