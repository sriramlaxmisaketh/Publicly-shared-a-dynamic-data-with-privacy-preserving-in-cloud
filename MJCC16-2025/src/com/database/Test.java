package com.database;




import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import java.security.Key;

public class Test {

	public static String encryption(String text, String key) {
		String ekey = "";
		byte[] byteArray = null;
		try {
			// Create key and cipher
			byteArray = text.getBytes();
			System.out.println(byteArray);
			Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
			Cipher cipher = Cipher.getInstance("AES");
			// encrypt the text
			cipher.init(Cipher.ENCRYPT_MODE, aesKey);
			byte[] encrypted = cipher.doFinal(byteArray);
			ekey = new String(encrypted);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ekey;
	}

	public static String decryption(byte[] encrypted , byte[] key){
		String ekey = "";
		try {
			// Create key and cipher
			Key aesKey = new SecretKeySpec(key, "AES");
			Cipher cipher = Cipher.getInstance("AES");
			// decrypt the text
			cipher.init(Cipher.DECRYPT_MODE, aesKey);
			String decrypted = new String(cipher.doFinal(encrypted));
			byte [] byteArray = decrypted.getBytes();
			ekey = byteArray.toString();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ekey;
	}
	
}
