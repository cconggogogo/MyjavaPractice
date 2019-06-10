package cn.practice.Algorithm.Leetcode.cys2018._03_GreedyAlgorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 10. 分隔字符串使同种字符出现在一起
 *
 * Input: S = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
 *
 *
 */
public class _11_partitionLabels {
    @Test
    public void test(){
        System.out.println("res: " + partitionLabels("ababcbacadefegdehijhklij"));
    }
    public List<Integer> partitionLabels(String s){
        int[] lastIndexsOfChar = new int[26];
        /**
         * 记录每一个字符的最后出现的下标，例如：
         * lastIndexsOfChar[0] = 8;
         * 代表：字母'a'最后一次出现在8号位置
         *
         * lastIndexsOfChar：
         * [8, 5, 7, 14, 15, 11, 13, 19, 22, 23, 20, 21,
         * 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
         *
         * ababcbaca  8 5 8 5 7 5 8 7 8
         * defegde    14 15 11 15 13 14 15
         * hijhklij   19 22 23 19 20 21 22 23
         */
        for (int i = 0; i < s.length(); i++){
            lastIndexsOfChar[char2Index(s.charAt(i))] = i;
        }

        List<Integer> partitions = new ArrayList<>();
        int firstIndex = 0;
        while (firstIndex < s.length()){
            int lastIndex = firstIndex;

            for (int i = firstIndex; i < s.length() && i <= lastIndex; i++){
                int index = lastIndexsOfChar[char2Index(s.charAt(i))];
                if (index > lastIndex){
                    lastIndex = index;
                }
            }

            partitions.add(lastIndex - firstIndex + 1);
            firstIndex = lastIndex + 1;
        }
        return partitions;
    }

    public int char2Index(char c){
        return c - 'a';
    }
}
