package com.kangtian.util.singleton;

/**反射，序列化会破坏单例。枚举类实现可避免
 * 饿汉式单例：
 * 优点：没有加锁，执行效率会提高。
 * 缺点：类加载时就初始化，浪费内存。
 */
public class Singleton2 {
    private static com.kangtian.util.singleton.Singleton2 instance=new Singleton2();

    //禁止实例
    private Singleton2(){

    }

    /**
     * 假设两个线程A，B。A进入到if后未初始化便将时间片让给了B。B初始化后，时间片让给A，此时A接着初始化
     * @return
     */
    public static Singleton2 getInstance(){
        return instance;
    }

}
