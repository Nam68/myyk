package myyk.backend.controller.global;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import myyk.backend.controller.BaseController;
import myyk.util.annotation.ServiceFunction;

@Controller
@ServiceFunction
public class HomePageController extends BaseController {

	@RequestMapping("/globalPage/homePage.do")
	public String show() {
		return "/globalPage/homePage";
	}
	
}
