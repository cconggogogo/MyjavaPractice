package cn.practice.DesignPatterns.Proxy.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 用于动态生成一个代理对象
 */
public class CreateProxy implements InvocationHandler {
    private Object target;

    // 用于创建代理对象(代替执行核心业务)的方法
    public Object create(Object target){
        this.target = target;
        return Proxy.newProxyInstance(target.getClass()
                .getClassLoader(), target
                .getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开始");
        Object result = method.invoke(target, args);
        System.out.println("结束");
        return result;
    }
}
