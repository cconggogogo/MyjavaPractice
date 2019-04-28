package cn.practice.BZhan.DesignPatterns.Decorator;

public class Test {
    @org.junit.Test
    public void test(){
        RingPhoneDecorator ringPhoneDecorator = new RingPhoneDecorator(new IPhone());
        MusicPhoneDecorator musicPhoneDecorator = new MusicPhoneDecorator(ringPhoneDecorator);
        musicPhoneDecorator.call();
    }
}
