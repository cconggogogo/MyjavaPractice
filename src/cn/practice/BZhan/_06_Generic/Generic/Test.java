package cn.practice.BZhan._06_Generic.Generic;

public class Test {
    public static<T> void test(T[] t, int start, int end){
        T temp;
        temp = t[start];
        t[start] = t[end];
        t[end] = temp;
    }
}
