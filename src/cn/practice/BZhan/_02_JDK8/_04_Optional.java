package cn.practice.BZhan._02_JDK8;

import javax.swing.text.html.Option;
import java.util.Optional;

public class _04_Optional {
    public static void main(String[] args) {
        Optional<String> optional = Optional.of("hello");
//        System.out.println(optional.isPresent());
//        System.out.println(optional.get());
//        optional.ifPresent((value) -> System.out.println(value));
//        System.out.println(optional.orElse("无值"));
        System.out.println(optional.orElseGet(()->"default"));
    }
}
