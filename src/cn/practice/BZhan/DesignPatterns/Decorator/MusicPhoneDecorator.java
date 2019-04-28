package cn.practice.BZhan.DesignPatterns.Decorator;

public class MusicPhoneDecorator extends PhoneDecorator{

    public MusicPhoneDecorator(Phone p) {
        super(p);
    }

    @Override
    public void call() {
        super.call();
        System.out.println("可以听音乐了");
    }
}
