package myyk.util;

import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import myyk.util.exception.SystemException;

public class BaseApp {

	/**
	 * <p>양방향 암호화에 사용되는 키값.</p>
	 */
	private static final String KEY = "ym7io5uk12u24y59";

	/**
	 * <p>문자열을 암호화한다.</p>
	 * 
	 * @param target 대상 문자열
	 * @return 암호화된 문자열
	 * @throws SystemException 웹 전용 예외상황
	 */
	public static String encrypt(String target) throws SystemException{
		
		byte[] targetBytes = target.getBytes();
		byte[] key = KEY.getBytes();		
		
		try {
			SecretKeySpec keySpec = null;
			
			keySpec = new SecretKeySpec(key, "AES");
			Cipher cipher = Cipher.getInstance("AES");
			
			cipher.init(Cipher.ENCRYPT_MODE, keySpec);
			
			Encoder encoder = Base64.getEncoder();
			return new String(encoder.encode(cipher.doFinal(targetBytes)));
			
		} catch (GeneralSecurityException e) {
			throw new SystemException("encoding failed");
		}
	}
	
	/**
	 * <p>양방향 암호를 복호화한다.</p>
	 * 
	 * @param encrypted 암호화된 문자열
	 * @return 복호화된 문자열
	 * @throws SystemException 웹 전용 예외상황
	 */
	public static String decrypt(String encrypted) throws SystemException{
		
		byte[] target = encrypted.getBytes();
		byte[] key = KEY.getBytes();
		
		try {
			SecretKeySpec keySpec = null;
			
			keySpec = new SecretKeySpec(key, "AES");
			Cipher cipher = Cipher.getInstance("AES");
			
			cipher.init(Cipher.DECRYPT_MODE, keySpec);
			Decoder encoder = Base64.getDecoder();
			return new String(cipher.doFinal(encoder.decode(target)));
			
		} catch (GeneralSecurityException e) {
			throw new SystemException("encoding failed");
		}
	}
	
	/**
	 * <P>비밀번호 해싱.</P>
	 * 
	 * @param password 비밀번호
	 * @param Salt 솔트
	 * @return 해싱된 비밀번호
	 * @throws Exception 모든 예외상황
	 */
	public static String doHashing(String password, String Salt) throws SystemException {

		byte[] passwordBytes = password.getBytes();
		
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			throw new SystemException("hashing failed");
		}
 
		// key-stretching
		for(int i = 0; i < 10000; i++) {
			String temp = byteToString(passwordBytes) + Salt;
			md.update(temp.getBytes());
			passwordBytes = md.digest(); 
		}
		
		return byteToString(passwordBytes);
	}
	
	/**
	 * <p>난수를 발생시킨다.</p>
	 * 
	 * @param length 난수의 길이
	 * @param seed 시드(null이면 랜덤, 숫자면 해당 숫자에 대한 고정 난수)
	 * @return 난수
	 */
	public static String createVariable(int length, Integer seed) {
		
//		SecureRandom r; // 128비트 기반이라 난수가 더 잘 형성되지만 여기선 별 의미 없을듯
		Random r;
		if(seed == null) {
//			r = new SecureRandom();
			r = new Random();
		} else {
//			r = new SecureRandom(seed);
			r = new Random(seed); // 난수가 순서대로 생성됨
		}
		
		StringBuffer sb = new StringBuffer();
		
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		int count = 3;
		
		for(int i = 0; i < length; i++) {
			
			char c;
			
			switch(r.nextInt(3)) {
				case 0:
					c = (char) (r.nextInt(('Z' - 'A') + 1) + 'A');
					count1++;
					count2 = 0;
					count3 = 0;
					break;
				case 1:
					c = (char) (r.nextInt(('z' - 'a') + 1) + 'a');
					count1 = 0;
					count2++;
					count3 = 0;
					break;
				case 2:
					c = (char) (r.nextInt(('9' - '0') + 1 )+ '0');
					count1 = 0;
					count2 = 0;
					count3++;
					break;
				default:
					c = '_';
			}
			
			if(count1 == count || count2 == count || count3 == count) {
				c = '_';
				count1 = 0;
				count2 = 0;
				count3 = 0;
			}
			sb.append(c);
		}
		return sb.toString();
	}
	
	// 바이트 값을 16진수로 변경.
	private static String byteToString(byte[] temp) {
		StringBuilder sb = new StringBuilder();
		for(byte a : temp) {
			sb.append(Integer.toHexString(a & 0xff));
		}
		return sb.toString();
	}
	
	/**
	 * <p>완성된 이메일을 반환한다.</p>
	 * 
	 * @param upperEmail 이메일 상단부
	 * @param lowerEmail 이메일 하단부
	 * @return 완성된 이메일
	 */
	public static String getEmail(String upperEmail, String lowerEmail) {
		return upperEmail + "@" + lowerEmail;
	}
	
	/**
	 * <p>문자열을 카멜형식으로 변환한다.</p>
	 * 
	 * @param target 문자열
	 * @return 카멜 형식 문자열
	 */
	public static String toCamelCase(String target) throws SystemException {
		
		if(target == null || target.isEmpty()) {
			throw new SystemException("string can not convert");
		}
		
		char[] cList = target.toCharArray();
		
		switch(cList[0]) {
			case'A':
				cList[0] = 'a';
				break;
			case'B':
				cList[0] = 'b';
				break;
			case'C':
				cList[0] = 'c';
				break;
			case'D':
				cList[0] = 'd';
				break;
			case'E':
				cList[0] = 'e';
				break;
			case'F':
				cList[0] = 'f';
				break;
			case'G':
				cList[0] = 'g';
				break;
			case'H':
				cList[0] = 'h';
				break;
			case'I':
				cList[0] = 'i';
				break;
			case'J':
				cList[0] = 'j';
				break;
			case'K':
				cList[0] = 'k';
				break;
			case'L':
				cList[0] = 'l';
				break;
			case'M':
				cList[0] = 'm';
				break;
			case'N':
				cList[0] = 'n';
				break;
			case'O':
				cList[0] = 'o';
				break;
			case'P':
				cList[0] = 'p';
				break;
			case'Q':
				cList[0] = 'q';
				break;
			case'R':
				cList[0] = 'r';
				break;
			case'S':
				cList[0] = 's';
				break;
			case'T':
				cList[0] = 't';
				break;
			case'U':
				cList[0] = 'u';
				break;
			case'V':
				cList[0] = 'v';
				break;
			case'W':
				cList[0] = 'w';
				break;
			case'X':
				cList[0] = 'x';
				break;
			case'Y':
				cList[0] = 'y';
				break;
			case'Z':
				cList[0] = 'z';
		}
		
		StringBuffer sb = new StringBuffer();
		for(char c : cList) {
			sb.append(c);
		}
		
		return sb.toString();
	}
}
