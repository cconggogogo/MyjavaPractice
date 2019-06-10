package cn.practice.DesignPatterns.CreateModel.Factory.FactoryMethod;

/**
 * 工厂方法模式创建的是一个对象，
 * 要同时创建多个对象，就可以使用抽象工厂模式
 */
public interface AnimalFactory {
    public Animal getAnimal();
}
