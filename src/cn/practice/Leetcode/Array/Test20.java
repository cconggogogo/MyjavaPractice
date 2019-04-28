package cn.practice.Leetcode.Array;
/**
 *定义栈的数据结构，
 * 请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */
/**
 * 分析：
 * 其实就是已经有了栈的对象的存在，
 * 但是这里是自己定义对象，自己用已知的数据结构作为容器来
 * 实现栈的进出栈的操作
 */

import java.util.Stack;
import java.util.Arrays;
public class Test20 {
    /*借用辅助栈存储min的大小，自定义了栈结构
     */
    private int size;
    private int min = Integer.MAX_VALUE;
    private Stack<Integer> minStack = new Stack<Integer>();
    private Integer[] elements = new Integer[10];
    public void push(int node) {
        ensureCapacity(size+1);
        elements[size++] = node;
        if(node <= min){
            minStack.push(node);
            min = minStack.peek();
        }else{
            minStack.push(min);
        }
    }

    private void ensureCapacity(int size) {
        // TODO Auto-generated method stub
        int len = elements.length;
        if(size > len){
            int newLen = (len*3)/2+1; //每次扩容方式
            elements = Arrays.copyOf(elements, newLen);
        }
    }
    public void pop() {
        Integer top = top();
        if(top != null){
            elements[size-1] = (Integer) null;
        }
        size--;
        minStack.pop();
        min = minStack.peek();
    }

    public int top() {
        if(!empty()){
            if(size-1>=0)
                return elements[size-1];
        }
        return (Integer) null;
    }
    public boolean empty(){
        return size == 0;
    }

    public int min() {
        return min;
    }

    public static void main(String[] args) {
        Test20 test20 = new Test20();
        test20.push(4);
        test20.push(2);
        test20.push(3);
        test20.pop();
        System.out.println(test20.min);
    }
}

