package singleton;

/**
 * 登记模式
 * 整合了一二的优点，推荐使用此方法建立单例
 */
public class Singleton3 {

    //禁止实例
    private Singleton3(){

    }
    /**
     * 只有调用getInstance,即内部类CreateInstance第一次初始化时才会创建实例
     * @return
     */
    public static   Singleton3 getInstance(){
        return CreateInstance.SINGLETON_3;
    }
    private static  class CreateInstance{
        private static final Singleton3 SINGLETON_3=new Singleton3();
    }


}
