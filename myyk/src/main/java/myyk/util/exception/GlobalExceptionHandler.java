package myyk.util.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import myyk.backend.BaseController;

@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(SystemException.class)
	public ModelAndView SystemExceptionHandler (SystemException exception) {
		
		LOGGER.error("GlobalExceptionHandler: " + exception.getMessage());
		exception.printStackTrace();
		
		ModelAndView mav = new ModelAndView("/globalPage/systemError");
		mav.addObject(BaseController.MESSAGES, exception.getMessage());
		
		return mav;
		
	}
	
}
