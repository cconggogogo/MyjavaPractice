package cn.practice.Leetcode.Array;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */

/**
 * 分析：n<=1,只有一种
 * n=2,有两种
 * n>2,分析：
 * 如果你横着放，放一块之后(1*2),下面一块就确定了，结果为f(n-2)
 * 如果你竖着放，结果为f(n-1)
 */
public class Test10 {
    public static void main(String[] args) {
        Test10 test10 = new Test10();
        System.out.println(test10.solution(1));
        System.out.println(test10.solution(2));
        System.out.println(test10.solution(3));
        System.out.println(test10.solution(4));
        System.out.println(test10.solution(5));

    }

    public int solution(int target) {
        if (target <= 1){
            return 1;
        } else if (target == 2) {
            return 2;
        } else {
            return solution(target-1) + solution(target-2);
        }
    }
}
