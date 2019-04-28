package cn.practice.Leetcode.Array;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * f(1)=1;
 * f(2)=f(2-1)+f(2-2);
 * f(n)=f(n-1)+f(n-2)+...+f(n-n)=f(0)+...+f(n-1);
 * f(n-1)=f(0)+...+f(n-2);
 * 所以f(n)=f(n-1)+f(n-1)=2*f(n-1);
 */
public class Test9 {
    public static void main(String[] args) {
        Test9 test9 = new Test9();
        System.out.println(test9.count(2));
    }

    public int count(int number) {
        if (number<1){
            return -1;
        } else if (number ==1) {
            return 1;
        } else {
            return 2*count(number-1);
        }
    }
}
