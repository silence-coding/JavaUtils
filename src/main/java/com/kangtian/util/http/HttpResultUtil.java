package com.kangtian.util.http;



import java.util.HashMap;
import java.util.Map;

public class HttpResultUtil {
    private static Map<String,Object> successMap;
    private static Map<String,String> faileMap;
    private static final String  CODE="code";
    private static final String MSG="msg";
    private static final String DATA="data";


    public static  Map returnSuccess(String msg){
        successMap=new HashMap<String, Object>();
        successMap.put(CODE,"0");
        successMap.put(MSG,msg);
        return successMap;

    }
    public static  Map returnSuccess(String msg,Object data){
        successMap=new HashMap<String, Object>();
        successMap.put(CODE,"0");
        successMap.put(MSG,msg);
        successMap.put(DATA,data);
        return successMap;
    }
    public static  Map returnFaile(String msg){
        faileMap=new HashMap<String, String>();
        faileMap.put(CODE,"-1");
        faileMap.put(MSG,msg);
        return faileMap;
    }
}

