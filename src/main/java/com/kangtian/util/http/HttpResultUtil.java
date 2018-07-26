package com.kangtian.util.http;



import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HttpResultUtil {
    private static Map<String,Object> successMap;
    private static Map<String,String> faileMap;
    private static final String  CODE="code";
    private static final String MSG="msg";
    private static final String DATA="data";

    static  {
        successMap=new ConcurrentHashMap<String, Object>();
        successMap.put(CODE,"0");
        faileMap=new ConcurrentHashMap<String, String>();
        faileMap.put(CODE,"-1");
    }
    public static  Map returnSuccess(String msg){
        successMap.put(MSG,msg);
        return successMap;

    }
    public static  Map returnSuccess(String msg,Object data){
        successMap.put(MSG,msg);
        successMap.put(DATA,data);
        return successMap;
    }
    public static  Map returnFaile(String msg){
        faileMap.put(MSG,msg);
        return faileMap;
    }
}

