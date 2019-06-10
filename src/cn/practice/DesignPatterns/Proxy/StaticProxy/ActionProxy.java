package cn.practice.DesignPatterns.Proxy.StaticProxy;

/**
 * 代理对象（代理控制，可以加代码）
 */
public class ActionProxy implements Action{

    // 被代理对象
    private Action target;

    public ActionProxy(Action target){
        this.target = target;
    }

    @Override
    public void doAction() {
        long startTime = System.currentTimeMillis();
        target.doAction(); // 真正执行的业务
        long endTime = System.currentTimeMillis();
        System.out.println("共耗时：" + (endTime - startTime) + "毫秒");
    }
}
