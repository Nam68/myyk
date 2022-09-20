package myyk.backend.logic;

import org.springframework.beans.factory.annotation.Autowired;

import myyk.backend.repository.RepositoryManager;
import myyk.util.BaseApp;
import myyk.util.exception.SystemException;

public class BaseLogic extends BaseApp {
	
	@Autowired
	private RepositoryManager repositoryManager;
	
	protected RepositoryManager getRepositoryManager() {
		return repositoryManager;
	}
	
	/**
	 * <p>완성된 이메일을 반환한다.</p>
	 * 
	 * @param upperEmail 메일아이디
	 * @param lowerEmail 도메인
	 * @return 완성된 이메일
	 */
	public static String makeFullEmail(String upperEmail, String lowerEmail) {
		return upperEmail + "@" + lowerEmail;
	}
	
	/**
	 * <p>암호화된 이메일을 반환한다.</p>
	 * 
	 * @param upperEmail 메일아이디
	 * @param lowerEmail 도메인
	 * @throws SystemException 시스템 예외
	 */
	public static String getEncryptedEmail(String upperEmail, String lowerEmail) throws SystemException {
		return encrypt(makeFullEmail(encrypt(upperEmail), lowerEmail));
	}
	
	/**
	 * <p>복호화된 이메일을 반환한다.</p>
	 * 
	 * @param encrpytedEmail 암호화된 이메일
	 * @return 복호화된 이메일
	 * @throws SystemException 시스템 예외
	 */
	public static String getDecryptedEmial(String encrpytedEmail) throws SystemException {
		String[] decryptedEmail = decrypt(encrpytedEmail).split("@");
		String upperEmail = decrypt(decryptedEmail[0]);
		String lowerEmail = decryptedEmail[1];
		return makeFullEmail(upperEmail, lowerEmail);
	}
	
}
