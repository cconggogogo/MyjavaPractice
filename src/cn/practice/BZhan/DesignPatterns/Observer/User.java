package cn.practice.BZhan.DesignPatterns.Observer;

public class User implements Observer{
    String name;
    public User(String name){
        this.name = name;
    }
    @Override
    public void update(String message) {
        System.out.println("[" + name + "]" + "收到的消息是：" + message);
    }
}
