package cn.practice.BZhan.DesignPatterns.Factory.FactoryMethod;

public class DogFactory implements AnimalFactory{
    @Override
    public Animal getAnimal() {
        return new Dog();
    }
}
