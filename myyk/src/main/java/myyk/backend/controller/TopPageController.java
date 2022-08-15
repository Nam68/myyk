package myyk.backend.controller;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import myyk.backend.BaseController;
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
	
	@RequestMapping("/globalPage/skipTopPage.do")
	public String execute(HttpServletResponse response) {
		
		Cookie cookie = new Cookie(SKIP_TOP_PAGE, SKIP_TOP_PAGE);
		cookie.setMaxAge(0);
		cookie.setPath("/");
		
		response.addCookie(cookie);
		
		return "/globalPage/homePage";
	}
	
}
