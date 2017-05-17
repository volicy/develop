package com.boot.test.utils;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/**
 * DES加密:全称为Data Encryption Standard，即数据加密标准
 * 
 * DES是一种对称加密算法，�?谓对称加密算法即：加密和解密使用相同密钥的算法�?�DES加密算法出自IBM的研究，
 * 后来被美国政府正式采用，之后�?始广泛流传，但是近些年使用越来越少，因为DES使用56位密钥，以现代计算能力，
 * 24小时内即可被破解。虽然如此，在某些简单应用中，我们还是可以使用DES加密算法
 *
 * @author kevin
 */
public class DesUtils {

	public static void main(String[] args) throws Exception {
		
		// 加密
		System.out.println(encrypt("HsiHKe"));
		// 解密
		System.out.println(decrypt("8E65FA8451D7E4DD"));
				
		// 加密
		System.out.println(encrypt("aaa123", "ge#j$454%&6h*ur4rh5e55$t4Kdr385yJty".getBytes()));
		// 解密
		System.out.println(decrypt("1B291830D17513B5", "ge#j$454%&6h*ur4rh5e55$t4Kdr385yJty".getBytes("UTF-8")));
		
		// 加密
		System.out.println(encrypt("1qaz3edc5tgb", "ge#j$454%&6h*ur4rh5e55$t4Kdr385yJty".getBytes()));
		// 解密
		System.out.println(decrypt("3A4C65EB566CF7C938858A757E8EC880", "vbGl!a@RaPuIxS(BaFGG".getBytes("UTF-8")));
				
	}

	private final static String ALGORITHM = "DES";
	
	private static final String DEFAULT_ENCODING = "UTF-8";
	
	private static final String PASSWORD_CRYPT_KEY = "der455$t45u6hg44%&erh5ty";

	public final static String encrypt(String data) throws Exception {
		return byte2hex(encrypt(data.getBytes(DEFAULT_ENCODING), PASSWORD_CRYPT_KEY.getBytes()));
	}
	
	public final static String encrypt(String data, byte[] key) throws Exception {
		return byte2hex(encrypt(data.getBytes(DEFAULT_ENCODING), key));
	}
	
	public final static String encrypt(String data, byte[] key, String encoding) throws Exception {
		return byte2hex(encrypt(data.getBytes(encoding), key));
	}
	
	public final static String decrypt(String data) throws Exception {
		return new String(decrypt(hex2byte(data.getBytes(DEFAULT_ENCODING)), PASSWORD_CRYPT_KEY.getBytes()));
	}
	
	public final static String decrypt(String data, byte[] key) throws Exception {
		return new String(decrypt(hex2byte(data.getBytes(DEFAULT_ENCODING)), key));
	}
	
	public final static String decrypt(String data, byte[] key, String encoding) throws Exception {
		return new String(decrypt(hex2byte(data.getBytes(encoding)), key));
	}

	/**
	 * 加密
	 *
	 * @param data   加密内容
	 * @param key    秘钥
	 * @return
	 * @throws Exception
	 */
	private static byte[] encrypt(byte[] data, byte[] key) throws Exception {
		// DES算法要求有一个可信任的随机数�?
		SecureRandom sr = new SecureRandom();
		// 创建�?个DESKeySpec对象
		DESKeySpec dks = new DESKeySpec(key);
		// 创建�?个密匙工厂，然后用它把DESKeySpec转换�?
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
		SecretKey securekey = keyFactory.generateSecret(dks);
		// Cipher对象实际完成加密操作
		Cipher cipher = Cipher.getInstance(ALGORITHM);
		// 用密匙初始化Cipher对象
		cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);
		// 正式执行加密操作(现在，获取数据并加密)
		return cipher.doFinal(data);
	}

	/**
	 * 解密
	 *
	 * @param data   解密内容
	 * @param key    秘钥
	 * @return
	 * @throws Exception
	 */
	private static byte[] decrypt(byte[] data, byte[] key) throws Exception {
		// DES算法要求有一个可信任的随机数�?
		SecureRandom sr = new SecureRandom();
		// 创建�?个DESKeySpec对象
		DESKeySpec dks = new DESKeySpec(key);
		// 创建�?个密匙工�?
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
		// 将DESKeySpec对象转换成SecretKey对象
		SecretKey securekey = keyFactory.generateSecret(dks);
		// Cipher对象实际完成解密操作
		Cipher cipher = Cipher.getInstance(ALGORITHM);
		// 用密匙初始化Cipher对象
		cipher.init(Cipher.DECRYPT_MODE, securekey, sr);
		// 正式执行解密操作
		return cipher.doFinal(data);
	}

	/**
	 * 字符串转java字节�?
	 *
	 * @param b
	 * @return
	 */
	public static byte[] hex2byte(byte[] b) {
		if ((b.length % 2) != 0)
			throw new IllegalArgumentException("长度不是偶数");
		byte[] b2 = new byte[b.length / 2];
		for (int n = 0; n < b.length; n += 2) {
			String item = new String(b, n, 2);
			// 两位�?组，表示�?个字�?,把这样表示的16进制字符串，还原成一个进制字�?
			b2[n / 2] = (byte) Integer.parseInt(item, 16);
		}
		return b2;
	}

	/**
	 * java字节码转字符�?
	 *
	 * @param b
	 * @return
	 */
	public static String byte2hex(byte[] b) {
		String hs = "";
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1)
				hs = hs + "0" + stmp;
			else
				hs = hs + stmp;
		}
		return hs.toUpperCase();
	}
	
}
