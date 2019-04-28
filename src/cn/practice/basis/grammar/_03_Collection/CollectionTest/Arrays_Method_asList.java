package cn.practice.basis.grammar._03_Collection.CollectionTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Arrays_Method_asList {
    public static void main(String[] args) {
        // Arrays工具类的asList方法练习
        List<String> list = Arrays.asList("hwllo", "world", "123");

        for (String s: list) {
            System.out.println(s);
        }

        System.out.println("检验list的头String方法");
        System.out.println(list.toString());

        System.out.println("检验Collection的头String方法");
        Collection col = new ArrayList();
        col.add("haha");
        col.add(false);
        col.add(123);
        System.out.println(col.toString());
    }
}
