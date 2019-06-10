package cn.practice.DesignPatterns.CreateModel.Factory.SimpleFactory;

import org.junit.Test;

public class AnimalFactoryTest {
    @Test
    public void test(){
        Animal animal = AnimalFactory.createAnimal("cat");
        animal.eat();
    }
}
