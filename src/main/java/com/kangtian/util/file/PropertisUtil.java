package com.kangtian.util.file;

import java.io.*;
import java.util.HashMap;

public class PropertisUtil {
    public static HashMap<String,String>  prope=new HashMap<String, String>(100);

    public static void main(String[] args){
            String path="D:\\ftlpath/webpower/reset-password/reset-password_es.ftl";
            System.out.println(path.substring(path.lastIndexOf("/")+1,path.lastIndexOf(".")));












//        readFile("D:\\Code\\javautils\\src\\main\\java\\com\\kangtian\\util\\file\\prop.txt");
//        System.out.println(prope.toString());
    }

    public static HashMap<String, String> readFiletoMap(String path) {
        HashMap<String, String> propeMap = new HashMap<String, String>();
        String[] tem;
        String line="";
        try {
            BufferedReader in = new BufferedReader(new FileReader(path));
            line = in.readLine();
            while (line != null) {
               tem=line.split("=");
               if (tem.length>1)
                propeMap.put(tem[0],tem[1]);
                line = in.readLine();
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return propeMap;
    }
    public String readToString(String fileName) {
        String encoding = "UTF-8";
        File file = new File(fileName);
        Long filelength = file.length();
        byte[] filecontent = new byte[filelength.intValue()];
        try {
            FileInputStream in = new FileInputStream(file);
            in.read(filecontent);
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            return new String(filecontent, encoding);
        } catch (UnsupportedEncodingException e) {
            System.err.println("The OS does not support " + encoding);
            e.printStackTrace();
            return null;
        }
    }


}
