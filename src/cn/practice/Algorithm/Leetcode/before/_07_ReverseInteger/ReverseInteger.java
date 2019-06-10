package cn.practice.Algorithm.Leetcode.before._07_ReverseInteger;

/**
 * 逆序输出给定数字：
 * 举例:123 ->321
 * -123 -> -321
 *
 * corner case: 越界
 * int：-2147483648~2147483647
 * （2^32-1）~(-2^32)
 *
 * time: O(n)
 * space: O(1)，不需要额外的空间
 */
public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverse(100));
        System.out.println(reverse(-123));
        System.out.println(reverse(2147483647));
    }
    public static int reverse(int x){
        long res = 0;
        while (x != 0){
            res = res * 10 + x %10;
            x/=10;
            if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE)
                return 0;
        }
        return (int)res;
    }
}
