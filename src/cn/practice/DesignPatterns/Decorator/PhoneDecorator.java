package cn.practice.DesignPatterns.Decorator;

/**
 * 手机装饰者顶层抽象类
 */
public abstract class PhoneDecorator implements Phone{
    private Phone p;
    public PhoneDecorator(Phone p){
        this.p = p;
    }

    @Override
    public void call() {
        this.p.call();
    }
}
