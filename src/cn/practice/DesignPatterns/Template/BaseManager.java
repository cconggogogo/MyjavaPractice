package cn.practice.DesignPatterns.Template;

/**
 * 定义抽象类模板(把具体执行的操作定义为骨架)
 */
public abstract class BaseManager {
    public void action(String name, String method){
        if ("admin".equals(name)){
            execute(method); // 具体实现交给子类
        } else {
            System.out.println("暂无操作权限");
        }
    }

    public abstract void execute(String method);
}
