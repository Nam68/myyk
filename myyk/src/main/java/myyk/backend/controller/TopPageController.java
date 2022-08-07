package myyk.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import myyk.backend.BaseController;
import myyk.util.annotation.ServiceFunction;

@Controller
@ServiceFunction
public class TopPageController extends BaseController {

	@RequestMapping("/globalPage/topPage.do")
	public String execute() {
		return "/globalPage/topPage";
	}
	
}
