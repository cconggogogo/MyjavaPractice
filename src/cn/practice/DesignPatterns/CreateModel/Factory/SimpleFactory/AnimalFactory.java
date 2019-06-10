package cn.practice.DesignPatterns.CreateModel.Factory.SimpleFactory;

//只有一个动物工厂。根据传入的参数决定造什么动物。
public class AnimalFactory {

    private AnimalFactory() {
    }
    public static Animal createAnimal(String type) {
        if ("dog".equals(type)) {
            return new Dog();
        } else if ("cat".equals(type)) {
            return new Cat();
        } else {
            return null;
        }
    }
}

