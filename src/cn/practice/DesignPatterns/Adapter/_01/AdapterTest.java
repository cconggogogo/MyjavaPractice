package cn.practice.DesignPatterns.Adapter._01;

import org.junit.Test;

public class AdapterTest {
    @Test
    public void test(){
        PowerB powerB = new PowerBImpl();
        Adapter adapter = new Adapter(powerB);
        word(adapter);
        System.out.println("============");
        word(new PowerAImpl());
    }

    public void word(PowerA powerA){
        System.out.println("开始工作");
        powerA.insert();
        System.out.println("结束工作");
    }
}
