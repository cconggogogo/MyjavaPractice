package cn.practice.DesignPatterns.CreateModel.Factory.AbstractFactory;

public class ConcreteFactory1 extends AbstractFactory{
    @Override
    AbstractProductA createProductA() {
        return new ProductA1();
    }

    @Override
    AbstractProductB createProductB() {
        return new ProductB1();
    }
}
