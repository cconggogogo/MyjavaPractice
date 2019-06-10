package cn.practice.Others._01_BasicJavaMethod.BZhan._05_aop;

/**
 * 切面的实现类
 */
public class LogAdvice implements Advice{
    @Override
    public void beforeAdvice() {
        System.out.println("beforeTime: " + System.currentTimeMillis());
    }

    @Override
    public void afterAdvice() {
        System.out.println("afterTime: " + System.currentTimeMillis());
    }
}
