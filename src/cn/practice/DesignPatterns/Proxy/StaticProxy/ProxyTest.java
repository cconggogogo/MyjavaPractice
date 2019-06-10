package cn.practice.DesignPatterns.Proxy.StaticProxy;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ProxyTest {
    @Test
    public void test(){
        new ActionProxy(new Action() {
            @Override
            public void doAction() {
                System.out.println("hello world");
            }
        }).doAction();
    }

    @Test
    public void test2(){
        new ActionProxy(
                () -> {
                    System.out.println("hello world");
                }
        ).doAction();

        List list = Arrays.asList(1,2,3,4);
        list.forEach(System.out::println);

        new ActionProxy(new UserAction()).doAction();
    }
}
