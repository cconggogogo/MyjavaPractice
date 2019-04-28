package cn.practice.BZhan.DesignPatterns.Adapter._02;

/**
 * 空实现，这样的话，子类就不需要实现所有的方法了
 */
public abstract class AnimalFunction implements Animal{
    @Override
    public void sing() {

    }

    @Override
    public void cry() {

    }

    @Override
    public void run() {

    }

    @Override
    public void swim() {

    }
}
