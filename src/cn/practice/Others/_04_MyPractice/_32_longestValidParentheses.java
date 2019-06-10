package cn.practice.Others._04_MyPractice;

import java.util.Stack;

public class _32_longestValidParentheses {
    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(((())))"));
    }
    public static int longestValidParentheses(String s){
        Stack<Integer> stack = new Stack<>();
        int start = -1;
        int res = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '(')
                stack.push(i);
            else {
                if (stack.isEmpty()){
                    start = i;
                } else {
                    stack.pop();
                    if (stack.isEmpty()){
                        res = Math.max(res,i - start);
                    } else {
                        res = Math.max(res,i - stack.peek());
                    }
                }
            }
        }
        return res;
    }
}
