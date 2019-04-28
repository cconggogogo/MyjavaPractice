package cn.practice.BZhan.DesignPatterns.Singleton;

import java.io.Serializable;

/**
 * 单例模式：
 * 1.多线程的安全问题；
 * 2.加上volatile关键字保证变量的一致性；
 * 3.防止反射访问私有构造方法；
 * 4.让单例类可以被序列化(可以还原属性原来的值)
 */
public class Singleton implements Serializable {
    private volatile static Singleton singleton = null;
    private Singleton(){
        if (singleton!=null)
            throw new RuntimeException("此类对象为单例模式，已经被实例化了");
    }

    public static Singleton getInstance(){
        // 防止已经new过了
        if (singleton == null){
            synchronized (Singleton.class){
                if (singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
