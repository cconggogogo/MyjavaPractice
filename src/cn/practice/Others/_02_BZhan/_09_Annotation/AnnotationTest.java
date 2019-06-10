package cn.practice.Others._02_BZhan._09_Annotation;

import cn.practice.Others._01_BasicJavaMethod.BZhan._08_Enum.Color;
import cn.practice.Others._01_BasicJavaMethod.BZhan._09_Annotation.Cat;
import cn.practice.Others._01_BasicJavaMethod.BZhan._09_Annotation.MyAnnotation;
import org.junit.Test;

public class AnnotationTest {
    @Test
    public void test(){
        // 获取类的class文件
        Class<Cat> catClass = Cat.class;

        // 获取类上指定的注解
        MyAnnotation annotation = catClass.getAnnotation(MyAnnotation.class);

        // 获取注解上的属性值
        String name = annotation.name();
        int age = annotation.age();
        String[] likes = annotation.likes();
        Color color = annotation.color();

        // 实例化对象
        try {
            Cat cat = catClass.newInstance();
            cat.setAge(age);
            cat.setName(name);
            cat.setColor(color);
            cat.setLikes(likes);
            System.out.println(cat);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
