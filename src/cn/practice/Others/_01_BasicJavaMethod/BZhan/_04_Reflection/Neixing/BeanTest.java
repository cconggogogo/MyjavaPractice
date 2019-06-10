package cn.practice.Others._01_BasicJavaMethod.BZhan._04_Reflection.Neixing;

import org.junit.Test;

/**
 * 这个其实就是内省：
 * 通过配置文件，实现对象的创建和方法的调用，
 * 全程都没有看到 new
 */
public class BeanTest {
    @Test
    public void getBeanTest(){
        Config bean = (Config) BeanFactory.getBean("bean.name");
        System.out.println(bean);
    }
}
