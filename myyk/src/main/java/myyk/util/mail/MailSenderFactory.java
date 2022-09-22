package myyk.util.mail;

import java.nio.charset.StandardCharsets;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.http.MediaType;

import myyk.util.enumeration.Result;

public class MailSenderFactory {
	
	public static MailSender getMailSender() {
		MailSenderFactory factory = new MailSenderFactory();
		return factory.createMailSender();
	}
	
	public MailSender createMailSender() {
		return new MailSender(MailConfig.getMailConfig(), MailConfig.getSender());
	}

	@SuppressWarnings("unused")
	public class MailSender {
		
		private String from;
		
		private String to;
		
		private String subject;
		
		private String content;
		
		private boolean isHtml;
		
		private MimeMessage config;
		
		private String sender;
		
		public MailSender(MimeMessage config, String sender) {
			this.config = config;
			this.sender = sender;
			this.isHtml = false;
		}
		
		public MailSender setFrom(String from) {
			this.from = from;
			return this;
		}
		
		public MailSender setTo(String to) {
			this.to = to;
			return this;
		}
		
		public MailSender setSubject(String subject) {
			this.subject = subject;
			return this;
		}
		
		public MailSender setContent(String content) {
			this.content = content;
			return this;
		}
		
		public MailSender setHtml(boolean isHtml) {
			this.isHtml = isHtml;
			return this;
		}
		
		public Result send() {
	        try {
	        	String type = isHtml? MediaType.TEXT_HTML_VALUE : MediaType.TEXT_PLAIN_VALUE;
	        	
	            config.setFrom(new InternetAddress(sender));
	            config.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
	            config.setSubject(subject);
	            config.setContent(content, type + "; charset=UTF-8");
	            
	            Transport.send(config);    // send message
	            
	            return Result.SUCCESS;
	        } catch (MessagingException e) {
	            e.printStackTrace();
	            return Result.ERROR;
	        }
		}
	}
}
