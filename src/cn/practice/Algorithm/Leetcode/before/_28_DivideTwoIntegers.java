package cn.practice.Algorithm.Leetcode.before;

/**
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 *
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 *
 * 示例 1:
 *
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 *
 * 示例 2:
 *
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 说明:
 *
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
 * 贡献者
 */
public class _28_DivideTwoIntegers {
    public static void main(String[] args) {
        System.out.println(divide(123,23));
    }
    public static int divide(int dividend, int divisor){
        int sign = 1;
        if (dividend >0 && divisor <0 || dividend <0 && divisor >0)
            sign = -1;
        long ldividend = Math.abs((long)dividend);
        long ldivisor = Math.abs((long)divisor);
        if (ldividend < ldivisor) return 0;
        long lres = divide(ldividend,ldivisor);
        int res = 0;
        if (lres > Integer.MAX_VALUE){
            res = (sign == 1)? Integer.MAX_VALUE:Integer.MIN_VALUE;
        }else {
            res = (int)lres;
        }
        return res;
    }

    public static long divide(long ldividend,long ldivisor){
        if (ldividend < ldivisor) return 0;
        long sum = ldivisor;
        long multiple = 1;
        // 加不加等号的问题
        // 加等号：time:<O(logn),space:O(logn)
        // 不加等号：time:O(logn),space:O(logn)
        while ((sum + sum) < ldividend){
            sum += sum;
            multiple += multiple;
        }
        return multiple + divide(ldividend - sum,ldivisor);
    }
}
