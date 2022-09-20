package myyk.util.mail;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

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
		
		private MimeMessage config;
		
		private String sender;
		
		public MailSender(MimeMessage config, String sender) {
			this.config = config;
			this.sender = sender;
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
		
		public Result send() {
	        try {
	            config.setFrom(new InternetAddress(sender));
	            config.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
	            config.setSubject(subject);
	            config.setText(content);
	 
	            Transport.send(config);    // send message
	            
	            return Result.SUCCESS;
	        } catch (MessagingException e) {
	            e.printStackTrace();
	            return Result.ERROR;
	        }
		}
	}
}
