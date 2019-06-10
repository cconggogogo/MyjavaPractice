package cn.practice.Others._01_BasicJavaMethod.BZhan._02_JDK8;

import java.util.HashMap;
import java.util.Map;

public class _03_map {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"heldf");
        map.put(2,"df");
        map.put(3,"fdf");
        map.put(4,"fdf");
//        System.out.println(map.getOrDefault(1,"hfid"));
//        map.putIfAbsent(1,"jfod");

//        map.compute(1,(k,v) -> k + "1");

//        map.computeIfAbsent(2,(val) -> val + "11");

        map.merge(3,"ghfg h",(v1,v2) -> v1.concat(v2));
        map.forEach((key,value) -> System.out.println(key+"->"+value));
    }

}
