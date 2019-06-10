package cn.practice.DesignPatterns.Observer;

import org.junit.Test;

/**
 * 事件就是观察者模式：
 * 被观察者和观察者的对象之间没有关系
 *
 * 观察者模式再被观察者和观察者之间建立了一个抽象的耦合，
 * 观察者知道的仅仅是被观察者的一个列表
 */
public class TestDemo {
    @Test
    public void test(){
        Message message = new Message();
        Observer user1 = new User("jack");
        Observer user2 = new User("tom");
        Observer user3 = new User("block");
        message.registObserver(user1);
        message.registObserver(user2);
        message.registObserver(user3);
        message.setMessage("发送的消息");
    }
}
