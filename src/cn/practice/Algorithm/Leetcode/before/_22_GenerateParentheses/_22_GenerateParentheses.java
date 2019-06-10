package cn.practice.Algorithm.Leetcode.before._22_GenerateParentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * 给一个数字，输出该组可能的括号匹配的样式
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 * time:O(n!)倾向于这个
 * ,O(2^n)
 * space:O(n)
 *
 * 卡特兰数：
 * (0,n-1)(1,n-2)(2,n-3)... (n-1,0)
 */
public class _22_GenerateParentheses {
    public static void main(String[] args) {
        System.out.println(generateParenthesid(3));
    }
    public static List<String> generateParenthesid(int n){
        List<String> res = new ArrayList<>();
        if (n == 0) return res;
        helper(res, "", n, n);
        return res;
    }
    // left: 指的是当前的序列中余下的左括号的个数，
    // right：着的是当前的序列中余下的右括号的个数
    public static void helper(List<String> res,String s,int left, int right){
        // 比如：(()）),left=3>right=2一定不符合
        if (left > right) return;
        // 都放满了
        if (left == 0 && right == 0){
            res.add(s);
            return;
        }
        if (left > 0)
            helper(res,s + "(", left - 1,right);
        if (right > 0)
            helper(res, s + ")",left, right - 1);
    }
}
