package cn.practice.Others._03_MovieLearn._04_Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class CreateProxy implements InvocationHandler{
    private Object object;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("第一步");
        System.out.println("第二部");
        method.invoke(object,args);
        System.out.println("结束");
        return null;
    }

    public Object create(Object object){
        this.object = object;
        Object proxy = Proxy.newProxyInstance(object.getClass().getClassLoader(),object.getClass().getInterfaces(),this);
        return proxy;
    }
}
