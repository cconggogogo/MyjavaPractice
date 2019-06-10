package cn.practice.DesignPatterns.CreateModel.Factory.AbstractFactory;

/**
 * 抽象工厂模式，同时创建多个对象
 */
public abstract class AbstractFactory {
    abstract AbstractProductA createProductA();
    abstract AbstractProductB createProductB();
}
