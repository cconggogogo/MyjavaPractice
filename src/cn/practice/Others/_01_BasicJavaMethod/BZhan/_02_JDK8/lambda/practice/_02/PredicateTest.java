package cn.practice.Others._01_BasicJavaMethod.BZhan._02_JDK8.lambda.practice._02;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Predicate断言的使用方法：
 * 实际上接收一个lambda表达式即可
 */
public class PredicateTest {
    public void evaluate(List<Integer> lists,
                                Predicate<Integer> predicate){
        for (Integer i : lists){
            if (predicate.test(i))
                System.out.println(i + " ");
        }
    }

    @Test
    public void test(){
        List<Integer> lists = Arrays.asList(1,2,3,4,5,6,7);
//        evaluate(lists,(n) -> true);
//        evaluate(lists,n -> false);
        evaluate(lists,n -> n%2==0);

    }
}
