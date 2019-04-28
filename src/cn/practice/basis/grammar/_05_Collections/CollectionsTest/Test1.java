package cn.practice.basis.grammar._05_Collections.CollectionsTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
//        test1();
//        test2();
        test3();
    }

    private static void test3() {
        System.out.println("测试reverse");
        List<Integer> list = new ArrayList<>();
        list.add(34);
        list.add(23);
        list.add(53);
        list.add(11);
        System.out.println(list);
        Collections.reverse(list);
        System.out.println("reverse: " + list);

        System.out.println("max: " + Collections.max(list));
    }

    public static void test1() {
        List<Integer> list = new ArrayList<>();
        list.add(34);
        list.add(23);
        list.add(53);
        list.add(11);
        System.out.println(list);

        Collections.shuffle(list);
        System.out.println("shuffle之后的list：" + list);
    }

    public static void test2() {
        // 测试排序方法
        List<Integer> list = new ArrayList<>();
        list.add(34);
        list.add(23);
        list.add(53);
        list.add(11);
        Collections.sort(list);
        System.out.println("排序之后的list为：" + list);
        System.out.println();

        System.out.println("测试student类型");
        Student s1 = new Student("hyy",113);
        Student s2 = new Student("clj",122);
        Student s3 = new Student("zs",33);
        List<Student> list1 = new ArrayList<>();
        list1.add(s1);
        list1.add(s2);
        list1.add(s3);

        Collections.sort(list1, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                int num = s1.getAge() - s2.getAge();
                int num2 = num ==0? s1.getName().compareTo(s2.getName()):num;
                return num2;
            }
        });
        System.out.println(list1);
    }
}
