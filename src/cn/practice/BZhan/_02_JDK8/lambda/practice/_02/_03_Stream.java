package cn.practice.BZhan._02_JDK8.lambda.practice._02;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * 注意我们使用了 .stream() 方法将常规数组转化为流。
 * Java 8 增加了一些超棒的流
 * APIs。java.util.stream.Stream 
 * 接口包含许多有用的方法，能结合 Lambda
 * 表达式产生神奇的效果。我们将 Lambda 表达式 x -> x*x 
 * 传给 map() 方法，该方法会作用于流中的所有元素。
 * 之后，我们使用 forEach 方法打印数据中的所有元素：
 */
public class _03_Stream {
    /**
     * 求list中所有元素的平方
     */
    @Test
    public void test(){
        List<Integer> lists = Arrays.asList(1,2,3,4,5,6,7);
        for (Integer i: lists){
            int x = i*i;
            System.out.println(x);
        }
        // ------------------------------------
        // 等价于
        lists.stream().map(x -> x*x).forEach(System.out::println);
    }

    /**
     * 求list中所有元素的平方和
     * map+reduce方法
     */
    @Test
    public void test2(){
        List<Integer> lists = Arrays.asList(1,2,3,4,5,6,7);
        int sum = 0;
        for (Integer i: lists){
            int x = i*i;
            sum+=x;
        }
        System.out.println(sum);
        // ================================
        // 等价于
        sum = lists.stream().map(x ->x*x).reduce((x,y) -> x+y).get();
        System.out.println(sum);
    }
}
