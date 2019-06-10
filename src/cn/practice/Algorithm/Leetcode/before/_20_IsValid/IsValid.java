package cn.practice.Algorithm.Leetcode.before._20_IsValid;

import java.util.Stack;

/**
 * 括号匹配问题
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 *
 * Example 1:
 *
 * Input: "()"
 * Output: true
 * Example 2:
 *
 * Input: "()[]{}"
 * Output: true
 */

/**
 * 分析：
 * 如果是左括号:就把右括号放进去
 * 如果是右括号就和当前的栈顶比对
 */
public class IsValid {
    public static void main(String[] args) {
        System.out.println(isValid("([{}])"));
        System.out.println(isValid("([{dsfd}[)"));
    }

    public static boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        Stack<Character> stack = new Stack<>();
        for (Character ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(')');
            } else if (ch == '[') {
                stack.push(']');
            } else if (ch == '{') {
                stack.push('}');
            } else {
                if (stack.isEmpty() || stack.pop() != ch) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
