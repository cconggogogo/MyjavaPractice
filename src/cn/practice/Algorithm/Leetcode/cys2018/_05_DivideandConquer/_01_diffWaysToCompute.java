package cn.practice.Algorithm.Leetcode.cys2018._05_DivideandConquer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. 给表达式加括号
 *
 * Input: "2-1-1".
 *
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 *
 * Output : [0, 2]
 *
 *
 */
public class _01_diffWaysToCompute {
    @Test
    public void test(){
        System.out.println(diffWaysToCompute("2-1-1"));
    }
    public List<Integer> diffWaysToCompute(String input){
        List<Integer> ways = new ArrayList<>();
        for (int i = 0; i < input.length();i++){
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*'){
                List<Integer> left = diffWaysToCompute(input.substring(0,i));
                List<Integer> right = diffWaysToCompute(input.substring(i+1));
                for (int l : left){
                    for (int r: right){
                        switch (c){
                            case '+':
                                ways.add(l + r);
                                break;
                            case '-':
                                ways.add(l - r);
                                break;
                            case '*':
                                ways.add(l * r);
                                break;
                        }
                    }

                }
            }
        }
        if (ways.size() == 0)
            ways.add(Integer.valueOf(input));
        return ways;
    }

}
