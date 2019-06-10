package cn.practice.DesignPatterns.CreateModel.Factory.FactoryMethod;

public class CatFactory implements AnimalFactory{
    @Override
    public Animal getAnimal() {
        return new Cat();
    }
}
