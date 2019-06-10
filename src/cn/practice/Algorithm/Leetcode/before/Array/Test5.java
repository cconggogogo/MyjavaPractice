package cn.practice.Algorithm.Leetcode.before.Array;

import java.util.Stack;

class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack1.empty()&&stack2.empty()){
            throw new RuntimeException("Queue is empty!");
        }
        if(stack2.empty()){
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}

class Test5{
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.push(12);
        solution.push(23);
        solution.push(36);
        System.out.println(solution.pop());
        System.out.println(solution.pop());
        System.out.println(solution.pop());

    }
}

