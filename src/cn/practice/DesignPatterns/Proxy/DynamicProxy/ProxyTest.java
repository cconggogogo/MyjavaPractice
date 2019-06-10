package cn.practice.DesignPatterns.Proxy.DynamicProxy;

import org.junit.Test;

public class ProxyTest {
    @Test
    public void test(){
        CreateProxy createProxy = new CreateProxy();
        // 必须转换为接口类，而不能是实现类
        Subject subject = (Subject) createProxy.create(new Person());
        subject.shopping();
    }
}
