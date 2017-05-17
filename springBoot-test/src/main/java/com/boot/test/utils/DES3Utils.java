package com.boot.test.utils;



import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DES3Utils {
	private static Log log = LogFactory.getLog(DES3Utils.class);
    // 密钥
    //private final static String secretKey1 = "123456789012345678901234";
    // 向量
    private final static String iv = "01234567";
    // 加解密统�?使用的编码方�?
    private final static String encoding = "utf-8";

    public static void main(String[] args) {
    	String code="MjOxuPFxxKNSOzbY+amV6Q==";
    	String key="sun1qazzhen2wsx3yongedc4";
    	System.out.println(decrypt(code, key));
	}
    
    /**
     * 加密
     * @param str
     * @return
     */
    public static String encode(String str,String secretKey){
    	String code="";
    	if(StringUtils.isBlank(str))
    		return code;
    	try {
    		code= encode1(str,secretKey) ;
		} catch (Exception e) {
			log.debug("--加密错误");
		}
    	return code;
    }
    
    /**
     * 解密
     * @param code
     * @return
     */
    public static String decrypt(String code,String secretKey){
    	String str="";
    	if(StringUtils.isBlank(code))
    		return str;
    	try {
    		str= decode1(code,secretKey) ;
		} catch (Exception e) {
			log.debug("----解密错误");
		}
    	return str;
    }

    /**
     * 3DES加密
     *
     * @param plainText 普�?�文�?
     * @return
     * @throws Exception
     */
    public static String encode1(String plainText,String secretKey) throws Exception {
        Key deskey = null;
        DESedeKeySpec spec = new DESedeKeySpec(secretKey.getBytes(encoding));
        SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
        deskey = keyfactory.generateSecret(spec);

        Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
        IvParameterSpec ips = new IvParameterSpec(iv.getBytes());
        cipher.init(Cipher.ENCRYPT_MODE, deskey, ips);
        byte[] encryptData = cipher.doFinal(plainText.getBytes(encoding));
        return DES3Base64.encode(encryptData);
    }

    /**
     * 3DES解密
     *
     * @param encryptText 加密文本
     * @return
     * @throws Exception
     */
    public static String decode1(String encryptText,String secretKey) throws Exception {
        Key deskey = null;
        DESedeKeySpec spec = new DESedeKeySpec(secretKey.getBytes());
        SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
        deskey = keyfactory.generateSecret(spec);
        Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
        IvParameterSpec ips = new IvParameterSpec(iv.getBytes());
        cipher.init(Cipher.DECRYPT_MODE, deskey, ips);
        byte[] decryptData = cipher.doFinal(DES3Base64.decode(encryptText));
        return new String(decryptData, encoding);
    }

}

