package myyk.util.mail;

import java.util.Properties;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;


public class MailConfig {
	
	// 1. 발신자의 메일 계정과 비밀번호 설정
	private static final String USER = "myyk.system@outlook.com";
    private static final String PASSWORD = "Tractatus1@";
	
	public static MimeMessage getMailConfig() {
		        
        // 2. Property에 SMTP 서버 정보 설정
		Properties prop = new Properties();

		prop.put("mail.smtp.ssl.protocols", "TLSv1.2");
		prop.put("mail.smtp.host", "smtp-mail.outlook.com");
		prop.put("mail.smtp.port", 587);
		prop.put("mail.smtp.starttls.enable","true");
		prop.put("mail.smtp.auth", "true");

//		prop.put("mail.smtp.host", "smtp.gmail.com");
//	    prop.put("mail.smtp.port", 465);
//	    prop.put("mail.smtp.auth", "true");
//	    prop.put("mail.smtp.ssl.enable", "true");
//	    prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");

		// 3. SMTP 서버정보와 사용자 정보를 기반으로 Session 클래스의 인스턴스 생성
        Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USER, PASSWORD);
            }
        });
		        
        return new MimeMessage(session);
	}
	
	public static String getSender() {
		return USER;
	}
}