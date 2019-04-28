package cn.practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class Demo {
    public static void main(String[] args) {
        TreeSet<Integer> ts = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        ts.add(5);
        ts.add(1);
        ts.add(2);
        ts.add(4);
        ts.add(5);
        System.out.println(ts);
    }
}
