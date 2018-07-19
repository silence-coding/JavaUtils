package singleton;

/**
 * 懒汉式单例
 * 优点：第一次调用才初始化，避免内存浪费。
 * 缺点：必须加锁synchronized 才能保证单例
 */
public class Singleton1 {
    private static Singleton1  instance;
    //禁止实例
    private Singleton1(){

    }

    /**
     * 假设两个线程A，B。A进入到if后未初始化便将时间片让给了B。B初始化后，时间片让给A，此时A接着初始化
     * @return
     */
    public static synchronized   Singleton1 getInstance(){
        if (null==instance)
            instance=new Singleton1();
        return instance;
    }

}
