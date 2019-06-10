package cn.practice.DesignPatterns.Template;

/**
 * 实现抽象类，重写方法
 */
public class UserManager extends BaseManager{
    @Override
    public void execute(String method) {
        if ("add".equals(method)){
            System.out.println("add");
        } else if ("del".equals(method)){
            System.out.println("del");
        }
    }
}
