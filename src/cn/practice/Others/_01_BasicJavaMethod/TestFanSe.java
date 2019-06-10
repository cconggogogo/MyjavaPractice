package cn.practice.Others._01_BasicJavaMethod;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class TestFanSe {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Class c = arrayList.getClass();
        Method m = c.getMethod("add",Object.class);
        m.invoke(arrayList,"hello");
        arrayList.add(134);
        m.invoke(arrayList,"java");
        System.out.println(arrayList.toString());
    }
}
