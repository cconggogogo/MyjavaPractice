package cn.practice.DesignPatterns.Decorator;

/**
 * 手机具体实现类
 */
public class IPhone implements Phone{
    @Override
    public void call() {
        System.out.println("打电话");
    }
}
