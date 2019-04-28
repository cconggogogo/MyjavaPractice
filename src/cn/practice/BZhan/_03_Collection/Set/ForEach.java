package cn.practice.BZhan._03_Collection.Set;

import java.util.HashMap;

public class ForEach {
    public static void main(String[] args) {
        HashMap<Integer,String> hm = new HashMap<>();
        hm.put(1,"hfu");
        hm.put(2,"dwsd");
        hm.put(3,"sd");
        hm.put(4,"sdsd");
        hm.forEach((key,value) -> System.out.println(key+"->"+value));
    }
}
