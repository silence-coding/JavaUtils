package com.kangtian.util.singleton;

/**
 * 可考虑改为Singleton3的枚举类，抗序列化，反射破坏
 * 获取单例样式如下
 * Singleton.SINGLETON.getInstance();
 */
public enum Singleton {
        SINGLETON;
        private Object singleton = null;
        private Singleton() {
            singleton=new Object();
        }
        public Object getInstance() {
            return singleton;
        }
}



