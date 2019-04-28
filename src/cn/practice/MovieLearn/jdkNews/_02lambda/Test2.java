package cn.practice.MovieLearn.jdkNews._02lambda;

import java.util.*;

public class Test2 {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("001","zhangsan");
        map.put("002","lisi");
        map.put("003","wangwu");
        map.put("004","zhaoliu");
//        method(map);
//        method2(map);
        List<String> items = new ArrayList<>();
        items.add("A");
        items.add("B");
        items.add("C");
        items.add("D");
        items.add("E");
        method3(items);
    }
    public static void method3(List<String> items){
        // 输出item
        items.forEach(item->System.out.println(item));
        System.out.println();

        // 输出的简化版
        items.forEach(System.out::println);
        System.out.println();

        // 输出满足条件的item
        items.forEach(item->{
            if("C".equals(item)){
                System.out.println(item);
            }
        });
        System.out.println();

        //Stream and filter
        //Output : B
        items.stream()
                .filter(s->s.contains("B"))
                .forEach(System.out::println);

    }

    private static void method2(Map<String, String> map) {
        map.forEach((k,v) -> {
            System.out.println("key: " + k + "value: " + v);
        });
        map.forEach((k,v) -> {
            System.out.println("key: " + k + "value: " + v);
            if ("001".equalsIgnoreCase(k)){
                System.out.println("hello K");
            }
        });
    }

    public static void method(Map<String,String> map){
        Set<Map.Entry<String,String>> list = map.entrySet();
        for (Map.Entry<String,String> i : list){
            System.out.println(i.getKey() + "--" + i.getValue());
        }
    }
}
