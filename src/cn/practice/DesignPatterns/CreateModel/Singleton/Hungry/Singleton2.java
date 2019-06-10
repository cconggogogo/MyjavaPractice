package cn.practice.DesignPatterns.CreateModel.Singleton.Hungry;

/**
 * 使用静态内部类实现单例模式
 * 好处：
     * 这种方式不仅具有延迟初始化的好处，
     * 而且由 JVM 提供了对线程安全的支持。
 */
public class Singleton2 {

    private Singleton2() {
    }

    private static class SingletonHolder {
        private static final Singleton2 INSTANCE = new Singleton2();
    }

    public static Singleton2 getUniqueInstance() {
        return SingletonHolder.INSTANCE;
    }
}
