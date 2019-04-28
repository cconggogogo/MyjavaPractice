package cn.practice.BZhan._02_JDK8.lambda.practice.basicMethod;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class bianli {
    @Test
    public void test(){
        String[] str = {"fdsf","fdsg","fdsf","fdsg","fdsf","fdsg"};
        List<String> lists = Arrays.asList(str);

        // 遍历方式一
        for (String s: lists){
            System.out.println(s);
        }

        // 遍历方式二
        lists.forEach(p -> System.out.println(p));

        // 遍历方式三
        lists.forEach(System.out::println);
    }
}
