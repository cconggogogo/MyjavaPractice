package cn.practice.Interview.zijietiaodong.jinritoutiao_2018._01_MaxIndex;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 字节跳动2017：最大映射题目
 *
 * 有 n 个字符串，每个字符串都是由 A-J 的大写字符构成。
 * 现在你将每个字符映射为一个 0-9 的数字，不同字符映射为不同的数字。
 * 这样每个字符串就可以看做一个整数，唯一的要求是这些整数必须是正整数且它们的字符串不能有前导零。
 * 现在问你怎样映射字符才能使得这些字符串表示的整数之和最大？
 *
 * 输入描述:
 *
 * 每组测试用例仅包含一组数据，每组数据第一行为一个正整数 n ，
 * 接下来有 n 行，每行一个长度不超过 12 且仅包含大写字母 A-J 的字符串。
 * n 不大于 50，且至少存在一个字符不是任何字符串的首字母。
 *
 * 输出描述:
 *
 * 输出一个数，表示最大和是多少。
 *
 * 输入例子:
 *
 * 2
 *
 * ABC
 *
 * BCA
 *
 * 输出例子:
 *
 * 1875 = 897 + 978
 * 记录权重
 */

/**
 * 核心思想: 把变化的字符串中每个字符的权重计算出来，
 * 比如：ABCD，用一个数字数组存储每一个字符的权重，比如A对应于第一个位置
 * D： 0+10^0
 */
public class MaxIndex {
    public static void main(String[] args) {
        maxMapping();
    }

    private static void maxMapping() {
        System.out.println("输入第一行的数字n: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str;
        long max = 0;
        long[] numbers = new long[10];
        for (int k = 0; k < n; k++){
            str = sc.nextLine();
            while (str == null || str.equals("")){
                str = sc.nextLine();
            }
            for (int i = str.length() - 1; i >= 0; i--){
                numbers[str.charAt(i) - 'A'] += Math.pow(10, str.length() - i - 1);
            }
        }
        Arrays.sort(numbers);
        // 排序之后，直接计算即可
        for (int i = 0; i <= 9; i++){
            max += (numbers[i] * i);
        }
        System.out.println(max);
    }
}
