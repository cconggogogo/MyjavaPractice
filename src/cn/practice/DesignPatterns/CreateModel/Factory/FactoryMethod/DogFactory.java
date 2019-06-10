package cn.practice.DesignPatterns.CreateModel.Factory.FactoryMethod;

public class DogFactory implements AnimalFactory{
    @Override
    public Animal getAnimal() {
        return new Dog();
    }
}
