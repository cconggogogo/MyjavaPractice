package cn.practice.Algorithm.Leetcode.cys2018._01_DoublePointer;

import org.junit.Test;

/**
 * 4. 回文字符串
 *
 * 题目描述：可以删除一个字符，判断是否能构成回文字符串。
 *
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 */
public class _04_validPalindrome {
    @Test
    public void test(){
        System.out.println(new _04_validPalindrome().validPalindome("abba"));
        System.out.println(new _04_validPalindrome().validPalindome("abcdba"));
        System.out.println(new _04_validPalindrome().validPalindome("abcdbae"));
    }
    public boolean validPalindome(String s){
        for (int i = 0, j = s.length() - 1;i < j; i++, j--){
            if (s.charAt(i)!=s.charAt(j)){
                return isPalindrome(s,i,j-1) || isPalindrome(s,i+1,j);
            }
        }
        return true;
    }
    public boolean isPalindrome(String s, int i , int j){
        while (i < j){
            if (s.charAt(i++) != s.charAt(j--)){
                return false;
            }
        }
        return true;
    }
}
