package cn.practice.Tools;

import java.util.Stack;

public class Tools {
    public static void main(String[] args) {
        // 进制测试
        System.out.println("5的二进制表示为：" + Integer.toBinaryString(5));


    }

    public static void StackDemo(){
        // 测试栈
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.peek());
    }

}
