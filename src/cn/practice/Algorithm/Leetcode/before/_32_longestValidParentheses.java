package cn.practice.Algorithm.Leetcode.before;

import java.util.Stack;

/**
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * 示例 1:
 *
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 *
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 *
 * * 输入: "(())("
 *  * 输出: 4
 *  * 解释: 最长有效括号子串为 "(())"
 *
 *  time:O(n)
 *  space:O（n）
 */
public class _32_longestValidParentheses {
    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(()))"));
        System.out.println(longestValidParentheses(")()())"));

    }
    public static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        int start = -1;
        for (int i = 0; i< s.length(); i++){
            if (s.charAt(i) == '('){
                stack.push(i);
            }else {
                // 第一个字符不是'(',其实start指向的就是正确匹配位置的前一个位置
                if (stack.isEmpty()){
                    start = i;
                } else {
                    stack.pop();
                    if (stack.isEmpty()){
                        res = Math.max(res,i - start);
                    } else {
                        // （（）），这个很重要
                        res = Math.max(res, i - stack.peek());
                    }
                }
            }
        }
        return res;
    }
}
