package cn.practice.BZhan._09_Annotation;

import cn.practice.BZhan._08_Enum.Color;

import java.util.Arrays;

/**
 * 使用注解：
 * 把注解的值赋值给下面类中的变量（反射）
 */
@MyAnnotation(name = "admin",likes = {"鲫鱼"},color = Color.BLUE)
// ,age = 20
public class Cat {
    private String name;

    private int age;

    private String[] likes;

    private Color color;

    public Cat() {
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String[] getLikes() {
        return likes;
    }

    public void setLikes(String[] likes) {
        this.likes = likes;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", likes=" + Arrays.toString(likes) +
                ", color=" + color +
                '}';
    }
}
