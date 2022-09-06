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
}
