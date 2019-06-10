package cn.practice.Algorithm.Leetcode.cys2018._01_DoublePointer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 7. 最长子序列
 *
 * Input:
 * s = "abpcplea", d = ["ale","apple","monkey","plea"]
 *
 * Output:
 * "apple"
 *
 * 题目描述：删除 s 中的一些字符，使得它构成字符串列表 d 中的一个字符串，
 * 找出能构成的最长字符串。
 * 如果有多个相同长度的结果，返回字典序的最小字符串。
 *
 * 通过删除字符串 s 中的一个字符能得到字符串 t，
 * 可以认为 t 是 s 的子序列，
 * 我们可以使用双指针来判断一个字符串是否为另一个字符串的子序列。
 */
public class _07_findLongestWord {
    @Test
    public void test(){
        System.out.println(new _07_findLongestWord().findLongestWord("abpcplea", Arrays.asList("ale","apple","monkey","plea")));
    }
    public String findLongestWord(String s, List<String> lists){
        String longestWord = "";
        for (String target: lists){
            int l1 = longestWord.length(), l2 = target.length();
            if (l1 > l2 || (l1 == l2) && longestWord.compareTo(target) < 0){
                continue;
            }
            if (isSubstr(s,target)){
                longestWord = target;
            }
        }
        return longestWord;
    }
    public boolean isSubstr(String s, String target){
        int i = 0, j = 0;
        while (i < s.length() && j < target.length()){
            // 只有找到了s中的某个字符在target出现过了，才后移
            if (s.charAt(i) == target.charAt(j)){
                j++;
            }
            i++;
        }
        return j == target.length();
    }
}
