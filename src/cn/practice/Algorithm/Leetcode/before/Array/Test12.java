package cn.practice.Algorithm.Leetcode.before.Array;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。
 * 求base的exponent次方。
 */

/**
 * 分析：比如：
 * 3^5与3^(-5)
 * 先算3^5,如果指数为负数就返回倒数就可以了
 *
 * 并且在累乘的时候运用了位运算
 *
 */
public class Test12 {

    public double Power(double base, int n) {
        double res = 1,curr = base;// res记录累乘的结果
        int exponent;
        if(n>0){
            exponent = n;
        }else if(n<0){
            if(base==0)
                throw new RuntimeException("分母不能为0");
            exponent = -n;
        }else{// n==0
            if (base == 0)
                throw new RuntimeException("分母不能为0");
            return 1;// 0的0次方
        }
        while(exponent!=0){
            if((exponent&1)==1)
                res*=curr;
            curr*=curr;// 翻倍
            exponent>>=1;// 右移一位
        }
        return n>=0?res:(1/res);
    }

    public static void main(String[] args) {
        Test12  test12 = new Test12();
        System.out.println("3.15的-2次方为：" + test12.Power(3.15,-2));
    }

}
