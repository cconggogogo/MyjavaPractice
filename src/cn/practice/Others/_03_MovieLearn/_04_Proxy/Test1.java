package cn.practice.Others._03_MovieLearn._04_Proxy;

public class Test1 {
    public static void main(String[] args) {
        CreateProxy createProxy = new CreateProxy();
        Person person = new Person();
        Object proxy = (Subject)createProxy.create(person);
        ((Subject) proxy).shopping();
    }
}
