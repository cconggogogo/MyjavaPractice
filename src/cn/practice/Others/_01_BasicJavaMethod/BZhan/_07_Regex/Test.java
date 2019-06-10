package cn.practice.Others._01_BasicJavaMethod.BZhan._07_Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    /**
     * Pattern类实现正则
     */
    @org.junit.Test
    public void test(){
        Pattern p = Pattern.compile("a*b");
        Matcher m = p.matcher("adfjdlfdosfjb");
        boolean matches = m.matches();
        System.out.println(matches);
    }

    /**
     * String类的方法对正则的补充
     */
    @org.junit.Test
    public void test2(){
        String s = "123434";
        System.out.println(s.matches("\\d+"));
    }
}
