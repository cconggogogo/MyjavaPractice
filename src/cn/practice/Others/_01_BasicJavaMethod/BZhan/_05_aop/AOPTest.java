package cn.practice.Others._01_BasicJavaMethod.BZhan._05_aop;

import cn.practice.Others._02_BZhan._05_aop.ProxyFactoryBean;
import org.junit.Test;

import java.io.InputStream;

public class AOPTest {
    @Test
    public void test(){
        InputStream in = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("cn/practice/Others/_01_BasicJavaMethod/BZhan/_05_aop/bean.properities");
        BeanFactory beanFactory = new BeanFactory(in);
        ProxyFactoryBean proxyFactoryBean = (ProxyFactoryBean) beanFactory
                .getBean("bean");
        IManager proxy = (IManager) proxyFactoryBean.getProxy();
        proxy.add("woshihgd");
    }
}
