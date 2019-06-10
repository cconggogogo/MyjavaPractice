package cn.practice.Others._04_MyPractice;

/**
 * 不用运算符求两个数得商
 */
public class _28_DivideTwoIntegers {
    public static void main(String[] args) {
        System.out.println(divide(13,2));
    }
    public static int divide(int dividend, int divisor){
        int sign = 1;
        if (dividend < 0 && divisor >0 || dividend > 0 && divisor < 0)
            sign = -1;
        long dividends = Math.abs((long)dividend);
        long divisors = Math.abs((long)divisor);
        if (dividends < divisors) return 0;
        long lres = divide(dividends, divisors);
        int res;
        if (lres> Integer.MAX_VALUE){
           res =  sign == 1? Integer.MAX_VALUE:Integer.MIN_VALUE;
        }else {
            res = (int)lres;
        }
        return res;
    }

    private static long divide(long dividends, long divisors) {
        long sum = divisors;
        int multiple = 1;
        if (dividends<divisors) return 0;
        while (sum + sum < dividends){
            sum+=sum;
            multiple+=multiple;
        }
        return multiple + divide(dividends-sum,divisors);
    }
}
