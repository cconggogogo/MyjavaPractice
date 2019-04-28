package cn.practice.BZhan._02_JDK8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class _four_interface_new {
    public static void main(String[] args) {
//        foreachdemo();
//        functionTest();
//        supplierTest();
        predicateTest();
    }

    /**
     * Predicate接口
     */
    public static void predicateTest(){
        List<String> list = Arrays.asList("hello","world","hava");
        List<String> res = filter(list,(str) -> str.contains("c"));
        res.forEach(System.out::println);
    }

    public static List<String> filter(List<String> list, Predicate<String> p){
        List<String> res = new ArrayList<>();
        for (String s: list){
            if (p.test(s)){
                res.add(s);
            }
        }
        return res;
    }

    /**
     * Supplier接口
     */
    public static void supplierTest(){
        List<Integer> list = getNums(10,() -> (int)(Math.random()*100));
        list.forEach(System.out::println);
    }

    public static List<Integer> getNums(int num, Supplier<Integer> sup){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i<num;i++){
            list.add(sup.get());
        }
        return list;
    }

    /**
     * Function接口
     */
    public static void functionTest(){
        String s = strToUpp("hellold",(str) -> str.toUpperCase());
        System.out.println(s);
    }

    // 参数：第一个是传入值，第二个是返回值
    public static String strToUpp(String str , Function<String,String> f){
        return f.apply(str);
    }


    /**
     * jdk1.8的新的foreach遍历方法
     */
    public static void foreachdemo(){
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.add("java");
        list.add("demo");
        list.forEach(System.out::println);

        list.forEach(s -> System.out.println(s));
    }
}
