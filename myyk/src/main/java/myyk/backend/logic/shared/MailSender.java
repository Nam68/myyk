package myyk.backend.logic.shared;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import myyk.backend.dto.mail.MailDto;

@Service("mailSender")
public class MailSender {
	
	@Autowired
	private JavaMailSender mailSender;
	
	public void sendMail(final MailDto mail) {
		
		final MimeMessagePreparator preparator = new MimeMessagePreparator() {
			
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				
				final MimeMessageHelper messageHelper = 
						new MimeMessageHelper(mimeMessage, true, "UTF-8");
				
				messageHelper.setFrom(mail.getFrom());
				messageHelper.setTo(mail.getTo());
				messageHelper.setSubject(mail.getSubject());
				messageHelper.setText(mail.getContent());
				
			}
		};
		
		mailSender.send(preparator);
	}
	
}
