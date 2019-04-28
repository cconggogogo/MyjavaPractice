package cn.practice.BZhan._02_JDK8.lambda.practice.basicMethod;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class _03_Sort {
    @Test
    public void test(){
        // 旧的方式排序:使用匿名内部类排序
        String[] str = {"hello", "name", "world", "java",
        "haha", "javase", "chenjiujing"};
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
    }

    @Test
    public void test2(){
        // 使用 lambda expression 排序 players
        String[] str = {"hello", "name", "world", "java",
                "haha", "javase", "chenjiujing"};
        Arrays.sort(str,(s1,s2) -> s1.compareTo(s2));
        System.out.println(Arrays.toString(str));
    }

    @Test
    public void test3(){
        String[] str = {"hello", "name", "world", "java",
                "haha", "javase", "chenjiujing"};
        Arrays.sort(str,
                (s1,s2) -> s1.length() - s2.length());
        System.out.println(Arrays.toString(str));
    }

    /**
     * 根据截取的部分比较
     */
    @Test
    public void test4(){
        String[] str = {"hello", "name", "world", "java",
                "haha", "javase", "chenjiujing"};
        Arrays.sort(str,
                (s1,s2) -> s1.substring(s1.indexOf(" ")).compareTo(s2.substring(s2.indexOf(" "))));
        System.out.println(Arrays.toString(str));
    }

    /**
     * 根据最后一个字母
     */
    @Test
    public void test5(){
        String[] str = {"hello", "name", "world", "java",
                "haha", "javase", "chenjiujing"};
        Arrays.sort(str,
                (s1,s2) -> s1.charAt(s1.length() - 1) - s2.charAt(s2.length() - 1));
        System.out.println(Arrays.toString(str));
    }
}
