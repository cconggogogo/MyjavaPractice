package cn.practice.Others._01_BasicJavaMethod.BZhan._02_JDK8;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _02_Stream {
    public static void main(String[] args) {
        // foreach方法（接收操作）
        Stream<String> stream = Stream.of("hello","java","haha","nishi","jkdf");
//        stream.forEach((str) -> System.out.println(str));

        System.out.println("-----------");
        // filter方法
//        stream.filter((s) -> s.length()>=5).forEach(System.out::println);
        System.out.println("-------------");

        // distinct方法
//        stream.distinct().forEach(System.out::println);

        // map
//        stream.map(ss -> ss.toUpperCase()).forEach(System.out::println);

        // flatMap:一起遍历
//        Stream<List<Integer>> sss = Stream.of(Arrays.asList(1,2,3),Arrays.asList(4,5,6,7));
//        sss.flatMap(list -> list.stream()).forEach(System.out::println);

        // reduce(求最长的字串)
//        Optional<String> oop = stream.reduce((s1, s2) -> s1.length()>=s2.length()?s1:s2);
//        System.out.println(oop.get());

        // collect方法:Stream转换为list
        List<String> list = stream.collect(Collectors.toList());
        list.forEach(s -> System.out.println(s));

        //:: 方法的引用
        /**
         * 引用静态方法：Integer::valueof
         * 引用对象的方法list::add
         * 引用构造方法ArrayList::new
         */
    }
}
