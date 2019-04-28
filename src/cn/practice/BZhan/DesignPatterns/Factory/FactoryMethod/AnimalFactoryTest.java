package cn.practice.BZhan.DesignPatterns.Factory.FactoryMethod;

import org.junit.Test;

public class AnimalFactoryTest {
    @Test
    public void test(){
        AnimalFactory animalFactory = new CatFactory();
        Animal animal = animalFactory.getAnimal();
        animal.eat();
    }
}
