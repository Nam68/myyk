package myyk.util;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import myyk.backend.dto.mail.MailDto;
import myyk.backend.logic.shared.MailSender;
import myyk.util.mail.MailConfig;

public class App {

	public static void main(String[] args) {
		
		MailDto mail = new MailDto();
		
		mail.setFrom("epoche02@gmail.com");
		mail.setTo("epoche02@gmail.com");
		mail.setSubject("hi");
		mail.setContent("content");
		
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(MailConfig.class);
		MailSender sender = (MailSender) context.getBean("mailSender");
		sender.sendMail(mail);
		context.close();
	}
}
