package com.kangtian.util.encryption;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {


    public static  String getMd5(String str) throws NoSuchAlgorithmException {
        char hex[] = {
            '1', '2', '5', '3', '2', 'w', 's', '2', '2', 'q',
            'b', 'l', 'e', 'j', 's', 'b'
        };
        byte charsTemp[] = str.getBytes();
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(charsTemp);
        byte []  digest= messageDigest.digest();
        int len = digest.length;
        char[]  chars = new char[len];
        int k = 0;
        for (int i = 0; i < len; i++)
        {
            byte byte0 = digest[i];
            chars[k++] = hex[byte0 & 0xf];
        }
        return new String(chars);

    }
public static void main(String [] argd){
    try {
     System.out.print(getMd5("sadsa"));
    } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
    }
}
}

