package cn.practice.basis.grammar._02_Packaging_class;

import java.math.BigDecimal;

public class BigDecimalDemo {
    public static void main(String[] args) {
        BigDecimal num1 = new BigDecimal(1.23);
        BigDecimal num2 = new BigDecimal(3.32);

        System.out.println(num1);
        System.out.println("加法：" + num1.add(num2));
        System.out.println("减法：" + num1.subtract(num2));
        System.out.println("乘法：" + num1.multiply(num2));
        BigDecimal result = num1.divide(num2,2,BigDecimal.ROUND_CEILING);
        System.out.println("除法：" + result);
        System.out.println();
    }
}
