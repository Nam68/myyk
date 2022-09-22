package myyk.util.mail;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

import myyk.util.exception.SystemException;

public class MailTemplate {

	private static final String MAIL_PATH = "D:/myyk/myyk/src/main/webapp/template/";
	
	/**
	 * <p>메일 html을 문자열 형식으로 돌려준다.</p>
	 * <p>String.format()을 이용해서 빈 내용을 채워넣을 것.</p>
	 * 
	 * @param fileName html파일명
	 * @return html문자열
	 * @throws SystemException 입출력에러
	 */
	public static String getHtml(String fileName) throws SystemException {
		
//		File file = new File(Paths.get("").toAbsolutePath() + "/src/main/webapp/template/" + fileName);
		File file = new File(MAIL_PATH + fileName);

		StringBuffer sb = new StringBuffer();
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line = "";
			while((line = br.readLine()) != null) {
				sb.append(line.trim());
			}
		} catch (IOException e) {
			throw new SystemException("failed get mail template.");
		} 
		
		return sb.toString();
	}
	
	public static final String CHECK_EMAIL = "checkEmail.html";
	
	public static final String CHECK_EMAIL_SUBJECT_KO = "회원가입 안내 메일";
	public static final String CHECK_EMAIL_SUBJECT_JA = "アカウント登録メール";
	
	public static final String CHECK_EMAIL_TITLE_KO = "회원가입을 환영합니다!";
	public static final String CHECK_EMAIL_TITLE_JA = "アカウント登録ありがとうございます！";
	
	public static final String CHECK_EMAIL_INFO_KO = "아래의 코드를 클릭해서 등록을 완료해주십시오.";
	public static final String CHECK_EMAIL_INFO_JA = "下記のコードをクリックして、登録へお進みください。";

}
