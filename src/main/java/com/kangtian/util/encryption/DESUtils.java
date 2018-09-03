package com.kangtian.util.encryption;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.*;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * DESUtils 先采用BASE64Encoder对字符串进行处理，避免字符问题。
 * 再采用des 标准的SHA1PRNG加密方法进行加密
 */
public class DESUtils {
	private static Key key;
	private static String KEY_STR = "webapp";//加密秘钥,请自定义值
	private static String  charset = "UTF-8";
	private static String type = "DES";  //加密标准
	private static String  method="SHA1PRNG"; //加密方法
    private static Cipher cipher; //用于加解密操作的对象

	//初始化key  cipher
	static {
		try {
			KeyGenerator generator = KeyGenerator.getInstance(type); //获取秘钥对象
			SecureRandom secureRandom = SecureRandom.getInstance(method);//获取加密算法的强随机数对象
			secureRandom.setSeed(KEY_STR.getBytes());//根据key_str生成强随机数
			generator.init(secureRandom);//初始化秘钥对象
			key = generator.generateKey();//生成key
			generator = null;
			cipher= Cipher.getInstance(type);//获取cipher
            cipher.init(Cipher.ENCRYPT_MODE, key);//根据key初始化cipher
		} catch (NoSuchPaddingException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        }
    }

	//获取加密后的字符串
	public static String getEncryptString(String str) {
		BASE64Encoder base64encoder = new BASE64Encoder();
        byte[] bytes = new byte[0];
        try {
            bytes = str.getBytes(charset);
            byte[] doFinal = new byte[0];
            doFinal = cipher.doFinal(bytes);
            return base64encoder.encode(doFinal);
        } catch (IllegalBlockSizeException e) {
            throw new RuntimeException(e);
        } catch (BadPaddingException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    //获取加密后的字符串 将字符串解密
	public static String getDecryptString(String str) {
		BASE64Decoder base64decoder = new BASE64Decoder();
		try {
			byte[] bytes = base64decoder.decodeBuffer(str);
			byte[] doFinal = cipher.doFinal(bytes);
			return new String(doFinal, charset);
        } catch (IllegalBlockSizeException e) {
            throw new RuntimeException(e);
        } catch (BadPaddingException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}