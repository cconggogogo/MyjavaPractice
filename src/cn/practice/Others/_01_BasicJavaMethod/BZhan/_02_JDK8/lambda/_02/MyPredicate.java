package cn.practice.Others._01_BasicJavaMethod.BZhan._02_JDK8.lambda._02;

/**
 * 定义一个过滤器
 * @param <T>
 */
public interface MyPredicate<T> {
    boolean test(T t);
}

