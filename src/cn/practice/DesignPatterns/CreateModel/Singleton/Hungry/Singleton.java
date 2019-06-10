package cn.practice.DesignPatterns.CreateModel.Singleton.Hungry;

import java.io.Serializable;

/**
 * 单例模式：
 * 1.多线程的安全问题；
 * 2.加上volatile关键字保证变量的一致性；
 * 3.防止反射访问私有构造方法；
 * 4.让单例类可以被序列化(可以还原属性原来的值)
 */

public class Singleton implements Serializable {
    /**
     * singleton = new Singleton2();   实际上该指令分为一下三步执行，为了禁止指令重排，
     * 使用volatile进行优化：
                 * 为 uniqueInstance 分配内存空间
                 * 初始化 uniqueInstance
                 * 将 uniqueInstance 指向分配的内存地址
     */
    private volatile static Singleton singleton = null;
    private Singleton(){
        if (singleton!=null)
            throw new RuntimeException("此类对象为单例模式，已经被实例化了");
    }

    /**
     * DCL:双端检锁机制：
     * 如果只要一个if的话，如果两个线程同时申请进入，都满足第一个if时
     * 尽管有锁的存在，
     * 后面只是时间问题，都会执行new Singleton2(),new了两次
     */
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
