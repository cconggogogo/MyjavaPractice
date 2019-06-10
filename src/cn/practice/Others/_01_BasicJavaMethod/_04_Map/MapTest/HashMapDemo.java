package cn.practice.Others._01_BasicJavaMethod._04_Map.MapTest;

import java.util.*;

public class HashMapDemo {
    public static void main(String[] args) {
//        MaxIndex();
//        Send();
        Test3();
    }

    private static void Test3() {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("d", "zs");
        linkedHashMap.put("s","lj");
        linkedHashMap.put("b","hyy");
        linkedHashMap.put("a","clj");
        Set<String> set = linkedHashMap.keySet();
        for (String key: set) {
            System.out.println(key + "-" + linkedHashMap.get(key));
        }
    }

    private static void Test2() {
        // 测试键是student类型的
        HashMap<Student,String> hm = new HashMap<>();
        Student s1 = new Student("zs",11);
        Student s2 = new Student("ls",33);
        Student s3 = new Student("hyy",44);
        Student s4 = new Student("hyy",44);
        hm.put(s1,"zs");
        hm.put(s2,"ls");
        hm.put(s3,"hyy");
        hm.put(s4,"clj");

        Set<Map.Entry<Student,String>> set = hm.entrySet();
        for (Map.Entry<Student,String> map: set) {
            Student key = map.getKey();
            String value= map.getValue();
            System.out.println("键" + key.getName() +  key.getAge() + "值" + value);

        }
    }

    public static void Test1(){
        // 测试HashMap的基础语法
        System.out.println("测试HashMap的基础语法");
        HashMap hashMap = new HashMap();
        hashMap.put("001","zs");
        hashMap.put("001","hyy");
        hashMap.put("002","clj");
        System.out.println(hashMap.toString());
        System.out.println();

        System.out.println("remove方法");
        hashMap.remove("001");
        System.out.println(hashMap.toString());
        hashMap.put("003","ls");
        hashMap.put("004","ww");
        System.out.println();

        System.out.println("containsKey"
                + hashMap.containsKey("004"));
        System.out.println("isEmpty: " + hashMap.isEmpty());
        System.out.println();

        System.out.println("bianli");
        Set<String> set = hashMap.keySet();
        for (String key: set){
            System.out.println(key + "-" + hashMap.get(key));
        }
        System.out.println();

        System.out.println("遍历2");
        Set<Map.Entry<String, String>> set1 = hashMap.entrySet();
        for (Map.Entry<String, String> map: set1){
            System.out.println(map.getKey() + "-" +map.getValue());
        }
    }
}
