package cn.practice.DesignPatterns.Proxy.DynamicProxy;

/**
 * 被代理的实现类
 */
public class Person implements Subject{
    @Override
    public void shopping() {
        System.out.println("代购实现类");
    }
}
