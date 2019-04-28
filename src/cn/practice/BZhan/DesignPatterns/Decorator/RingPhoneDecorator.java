package cn.practice.BZhan.DesignPatterns.Decorator;

public class RingPhoneDecorator extends PhoneDecorator{
    public RingPhoneDecorator(Phone p) {
        super(p);
    }

    @Override
    public void call() {
        System.out.println("可以有彩铃了");
        super.call();
    }
}
