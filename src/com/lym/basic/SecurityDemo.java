package com.lym.basic;

import java.security.Key;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * java加密解密
 */
public class SecurityDemo {

	private static String src = "TestString";

	public static void main(String[] args) {
		jdkBase64();
		jdkDES();
		jdkAES();
	}

	// 使用JDK的base64实现
	public static void jdkBase64() {
		System.out.println("Base64:");
		Encoder encoder = Base64.getEncoder();
		String encode = encoder.encodeToString(src.getBytes());
		System.out.println("encode:  " + encode);
		Decoder decoder = Base64.getDecoder();
		String decode = new String(decoder.decode(encode));
		System.out.println("decode:  " + decode);
	}

	public static void jdkDES() {
		System.out.println("DES:");
		try {
			// 生成密钥Key
			KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
			keyGenerator.init(56);
			SecretKey secretKey = keyGenerator.generateKey();
			byte[] bytesKey = secretKey.getEncoded();

			// KEY转换
			DESKeySpec deSedeKeySpec = new DESKeySpec(bytesKey);
			SecretKeyFactory factory = SecretKeyFactory.getInstance("DES");
			Key convertSecretKey = factory.generateSecret(deSedeKeySpec);

			// 加密
			Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, convertSecretKey);
			byte[] encodeResult = cipher.doFinal(SecurityDemo.src.getBytes());
			System.out.println("DESEncode :" + byteToString(encodeResult));

			// 解密
			cipher.init(Cipher.DECRYPT_MODE, convertSecretKey);
			byte[] DecodeResult = cipher.doFinal(encodeResult);
			System.out.println("DESDncode :" + new String(DecodeResult));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void jdkAES() {
		System.out.println("AES:");
		try {
			// 生成Key
			KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
			keyGenerator.init(128);
			// keyGenerator.init(128, new SecureRandom("seedseedseed".getBytes()));
			// 使用上面这种初始化方法可以特定种子来生成密钥，这样加密后的密文是唯一固定的。
			SecretKey secretKey = keyGenerator.generateKey();
			byte[] keyBytes = secretKey.getEncoded();

			// Key转换
			Key key = new SecretKeySpec(keyBytes, "AES");

			// 加密
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] encodeResult = cipher.doFinal(SecurityDemo.src.getBytes());
			System.out.println("AESencode : " + byteToString(encodeResult));

			// 解密
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] decodeResult = cipher.doFinal(encodeResult);
			System.out.println("AESdecode : " + new String(decodeResult));

		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

	}
	
	private static String byteToString(byte[] bytes) {
		StringBuffer sBuffer = new StringBuffer();
		for (byte b : bytes) {
			// byte转Hex
			sBuffer.append(Integer.toHexString(b & 0xFF));
		}
		return sBuffer.toString();
	}
}
