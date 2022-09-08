package myyk.util;

import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import myyk.util.exception.SystemException;

public class BaseApp {

	/**
	 * <p>양방향 암호화에 사용되는 키값.</p>
	 */
	private static final String KEY = "ym7io5uk12u24y59";

	/**
	 * <p>솔트값의 길이.</p>
	 */
	private static final int SALT_SIZE = 16;

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
		
		SecretKeySpec keySpec = null;
		
		keySpec = new SecretKeySpec(key, "AES");
		Cipher cipher = null;
		try {
			cipher = Cipher.getInstance("AES");
		} catch (NoSuchAlgorithmException e) {
			// ignore log
			throw new SystemException("encoding failed");
		} catch (NoSuchPaddingException e) {
			// ignore log
			throw new SystemException("encoding failed");
		}
		
		try {
			cipher.init(Cipher.ENCRYPT_MODE, keySpec);
		} catch (InvalidKeyException e) {
			// ignore log
			throw new SystemException("encoding failed");
		}
		
		try {
			Encoder encoder = Base64.getEncoder();
			return new String(encoder.encode(cipher.doFinal(targetBytes)));
		} catch (IllegalBlockSizeException e) {
			// ignore log
			throw new SystemException("encoding failed");
		} catch (BadPaddingException e) {
			// ignore log
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
		
		SecretKeySpec keySpec = null;
		
		keySpec = new SecretKeySpec(key, "AES");
		Cipher cipher = null;
		try {
			cipher = Cipher.getInstance("AES");
		} catch (NoSuchAlgorithmException e) {
			// ignore log
			throw new SystemException("encoding failed");
		} catch (NoSuchPaddingException e) {
			// ignore log
			throw new SystemException("encoding failed");
		}
		
		try {
			cipher.init(Cipher.DECRYPT_MODE, keySpec);
		} catch (InvalidKeyException e) {
			// ignore log
			throw new SystemException("encoding failed");
		}
		
		try {
			Decoder encoder = Base64.getDecoder();
			return new String(cipher.doFinal(encoder.decode(target)));
		} catch (IllegalBlockSizeException e) {
			// ignore log
			throw new SystemException("encoding failed");
		} catch (BadPaddingException e) {
			// ignore log
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
			// ignore log
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
	 * <P>무작위 솔트값을 생성한다.</P>
	 *  
	 * @return 솔트
	 * @throws Exception 모든 예외상황
	 */
	public static String createSalt() {
		SecureRandom rnd = new SecureRandom();
		byte[] temp = new byte[SALT_SIZE];
		rnd.nextBytes(temp);
			
		return byteToString(temp);
			
	}
	
	// 바이트 값을 16진수로 변경.
	private static String byteToString(byte[] temp) {
		StringBuilder sb = new StringBuilder();
		for(byte a : temp) {
			sb.append(String.format("%02x", a));
		}
		return sb.toString();
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
