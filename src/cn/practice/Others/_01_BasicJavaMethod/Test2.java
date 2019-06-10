package cn.practice.Others._01_BasicJavaMethod;

import java.util.Arrays;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "hello";
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
        System.out.println("---------------");
        s1 = "hello world";
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
        System.out.println("数组转为集合：");
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7);
        System.out.println(list);
        int[] arr = { 24, 69, 80, 57, 13, 100 };
        System.out.println("binarySearch: " + Arrays.binarySearch(arr,166));
        int[] arr3 = {1,2,3,};
        int[] arr4 = new int[10];
    }
}
