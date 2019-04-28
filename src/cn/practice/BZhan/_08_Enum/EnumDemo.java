package cn.practice.BZhan._08_Enum;

import org.junit.Test;

import java.util.EnumMap;
import java.util.EnumSet;

public class EnumDemo {
    public static final int RED = 0X1;
    public static final int GREEN = 0x2;
    public static final int Black = 0x3;
    public int color;

    public void test(){
        color = RED;
        color = 4;
    }

    public Color color2;

    @Test
    public void test2(){
        color2 = Color.BLUE;
        System.out.println(color2);
        System.out.println(color2.name()); // name
        System.out.println(color2.ordinal()); // 下标
        System.out.println(color2.toString());
        Color[] values = Color.values();
    }

    /**
     * 集合对enum的支持
     * EnumSet
     * enumMap
     */
    @Test
    public void test3(){
        EnumSet<Color> enumSet = EnumSet.allOf(Color.class);
        for (Color c: enumSet){
            System.out.println(c);
        }

        EnumMap<Color,String> enumMap =
                new EnumMap<Color, String>(Color.class);
        enumMap.put(Color.RED,"red");
        enumMap.put(Color.GREEN,"green");
        enumMap.put(Color.BLUE,"blue");
        enumMap.forEach((k,v) -> System.out.println(k + "--" + v));

    }

}
