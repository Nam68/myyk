package myyk.backend.controller.global;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import myyk.util.cookie.CookieName;
import myyk.util.cookie.CookieTool;
import myyk.backend.controller.BaseController;
import myyk.util.annotation.ServiceFunction;
import myyk.util.exception.SystemException;

@Controller
@ServiceFunction
public class TopPageController extends BaseController {

	@RequestMapping("/globalPage/topPage.do")
	public String show(HttpServletRequest request) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		long period = System.currentTimeMillis() - sdf.parse("2018-09-16").getTime();
		
		DecimalFormat df = new DecimalFormat("###,###");
		request.setAttribute("period", df.format(period/1000/60/60/24));
		
		return "/globalPage/topPage";
	}
	
	@RequestMapping("/globalPage/skipTopPage.do")
	public String execute(HttpServletResponse response, String value) throws SystemException {
		if(value == null || value.isEmpty()) {
			throw new SystemException("property missing");
		}
		CookieTool.makeCookie(CookieName.SKIP_TOP_PAGE, value, CookieTool.COOKIE_WEEK, response);
		return "redirect:/globalPage/homePage.do";
	}
	
}
