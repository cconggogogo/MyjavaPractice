package cn.practice.DesignPatterns.CreateModel.Factory.SimpleFactory;

public class Cat extends Animal{
    @Override
    public void eat() {
        System.out.println("吃鱼");
    }
}
