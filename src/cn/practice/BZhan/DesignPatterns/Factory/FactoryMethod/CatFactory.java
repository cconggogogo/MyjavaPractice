package cn.practice.BZhan.DesignPatterns.Factory.FactoryMethod;

public class CatFactory implements AnimalFactory{
    @Override
    public Animal getAnimal() {
        return new Cat();
    }
}
