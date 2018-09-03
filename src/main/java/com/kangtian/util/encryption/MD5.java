package com.kangtian.util.encryption;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {


    public static  String getMd5(String str) throws NoSuchAlgorithmException {
        char hex[] = { //用于混淆 可自定义
            '1', '2', 'o', '3', 'h', 'w', 's', '2', '2', 'q'
                , '1', 'j', '5', '3', '2', 'w', 's', '2', '2', 'q',
            'b', 'l', 'e', 'j', 's','a'
        };
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");//获取MD5实例
        messageDigest.update(str.getBytes());//利用str 的char数组 更新 MD5
        byte []  digest= messageDigest.digest();//获取str 摘要
        int len = digest.length;
        char[]  chars = new char[len];
        int k = 0;
        for (int i = 0; i < len; i++)
        {
            byte  num = digest[i];
            chars[k++] = hex[ num& 25]; //num & 25 将 num压缩到25（小于hex的长度）以内，并以hex中的char替换混淆
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

