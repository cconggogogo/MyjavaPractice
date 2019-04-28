package cn.practice.BZhan.DesignPatterns.Proxy.StaticProxy;

public class UserAction implements Action{
    @Override
    public void doAction() {
        System.out.println("doAction");
    }
}
