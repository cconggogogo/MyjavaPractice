package cn.practice.BZhan.DesignPatterns.Proxy.DynamicProxy;

import org.junit.Test;

public class ProxyTest {
    @Test
    public void test(){
        CreateProxy createProxy = new CreateProxy();
        Person person = (Person) createProxy.create(new Person());
        person.shopping();
    }
}
