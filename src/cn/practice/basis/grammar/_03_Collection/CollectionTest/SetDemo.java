package cn.practice.basis.grammar._03_Collection.CollectionTest;

import java.util.*;

public class SetDemo {
    public static void main(String[] args) {
        System.out.println("测试hashSet方法");
        HashSetDemo();
        System.out.println();

        System.out.println("测试TreeSet方法");
        TreeSetDemo();
        System.out.println();

    }
    public static void HashSetDemo() {
        Set set = new HashSet();
        set.add("hello");
        set.add("hello");
        set.add("java");
        set.add(123);
        set.add(123);
        set.add("javase");

        System.out.println(set.toString());
        System.out.println();

        System.out.println("linkedHashSet");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add("helll");
        linkedHashSet.add("helll");
        linkedHashSet.add("java");
        linkedHashSet.add("java");
        linkedHashSet.add(123);
        System.out.println(linkedHashSet.toString());
        System.out.println();
    }

    // 测试treeSet方法
    public static void TreeSetDemo() {
        System.out.println("测试integer");
        TreeSet<Integer> in = new TreeSet<>();
        in.add(123);
        in.add(23);
        in.add(3);
        in.add(43);
        in.add(42);
        System.out.println(in.toString());
        System.out.println();

        System.out.println("测试string方法");
        TreeSet str = new TreeSet();
        str.add("d");
        str.add("c");
        str.add("b");
        str.add("h");
        str.add("a");
        System.out.println(str.toString());
        System.out.println();

        System.out.println("测试自定义学生类");
        Student s1 = new Student("zhangsan", 52);
        Student s2 = new Student("lisi",40);
        Student s3 = new Student("huyang", 23);
        Student s4 = new Student("chenliujing", 12);
        TreeSet<Student> stu = new TreeSet<>();
        stu.add(s1);
        stu.add(s2);
        stu.add(s3);
        stu.add(s4);
        for (Student s: stu){
            System.out.println(s.toString());
        }
        System.out.println();

        System.out.println("第二种方式");
        TreeSet<Student> stu2 = new TreeSet<Student>(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                int num = s1.getAge() - s2.getAge();
                int num2 = num == 0? s1.getName().compareTo(s2.getName()): num;
                return num2;
            }
        });
        stu2.add(s1);
        stu2.add(s2);
        stu2.add(s3);
        stu2.add(s4);
        for (Student s: stu2){
            System.out.println(s.toString());
        }
        System.out.println();
    }
}
