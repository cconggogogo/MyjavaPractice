package cn.practice.DesignPatterns.CreateModel.Factory.FactoryMethod;

public class Dog extends Animal {
    @Override
    public void eat() {
        System.out.println("吃骨头");
    }
}
