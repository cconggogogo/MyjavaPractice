package cn.practice.DesignPatterns.CreateModel.Singleton.Hungry;

/**
 * 线程不安全的饿汉式单例模式
 */
public class Singleton1 {

    private static Singleton1 uniqueInstance;

    /**
     * 防止反射
     */
    private Singleton1() {
        if (uniqueInstance!=null)
            throw new RuntimeException("该实例已存在");
    }

    public static Singleton1 getUniqueInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton1();
        }
        return uniqueInstance;
    }
}

