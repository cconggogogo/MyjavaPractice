package cn.practice.Others._01_BasicJavaMethod._04_Map.MapTest;


import java.util.*;

public class TreeMapDemo {
    public static void main(String[] args) {
        Test1();
        Test2();
        Test3();
        Test4();
    }

    private static void Test4() {
        System.out.println("测试每个字符出现的次数");
        System.out.println("请输入字符串");
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        char[] chs = line.toCharArray();
        TreeMap<Character,Integer> tm = new TreeMap<>();
        for (char ch: chs) {
            Integer num = tm.get(ch);
            if (num == null) {
                tm.put(ch,1);
            } else {
                tm.put(ch,num+1);
            }
        }
        Set<Character> set = tm.keySet();
        for (Character cc: set) {
            System.out.print(cc + "(" + tm.get(cc) + ")" + ",");
        }
    }

    private static void Test3() {
        LinkedHashMap<String,String> hmm = new LinkedHashMap<>();
        hmm.put("hello","hello");
        hmm.put("java","java");
        hmm.put("javaweb","javaweb");
        hmm.put("java","java");
        Set<String> set = hmm.keySet();
        System.out.println("测试LinkedHashMap");
        for (String key: set) {
            System.out.println(key + "-" + hmm.get(key));
        }
        System.out.println();
    }

    private static void Test2() {
        HashMap<String, String> hm = new HashMap<>();
        hm.put("hello","hello");
        hm.put("java","java");
        hm.put("javaweb","javaweb");
        hm.put("java","java");
        Set<String> set = hm.keySet();
        System.out.println("测试HashMap");
        for (String key: set) {
            System.out.println(key + "-" + hm.get(key));
        }
        System.out.println();

    }

    private static void Test1() {
        System.out.println("测试TreeMap");
        TreeMap<String,String> tm = new TreeMap<>();
        tm.put("hello","hello");
        tm.put("java","java");
        tm.put("javaweb","javaweb");
        tm.put("java","java");

        Set<String> set = tm.keySet();
        for (String key: set) {
            System.out.println(key + "-" + tm.get(key));
        }
        System.out.println();
    }
}
