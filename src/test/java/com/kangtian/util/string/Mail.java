package com.kangtian.util.string;


import java.util.HashMap;

public class Mail {
    public static final HashMap<String,String> mailMap=new HashMap<String, String>(){
        {
            put("163.com","cn");
            put("126.com","cn");
        }
    };

    public static boolean isDomesticMail(String mail){
        int index=mail.indexOf('@');
        if (StringUtils.isEmpty( mailMap.get(mail.substring(index+1))))
            return false;
            else
            return true;
    }

    public static  void main (String[] args){
            String mail="160125464@qq.com";
          System.out.print(isDomesticMail(mail));
    }
}
