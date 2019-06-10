package cn.practice.Algorithm.Leetcode.cys2018._03_GreedyAlgorithm;

/**
 * 7. 判断是否为子序列
 *
 * s中的所有字符都在t中出现，南那么s就是t的子串
 *
 * s = "abc", t = "ahbgdc"
 * Return true.
 *
 *
 */
public class _08_isSubsequence {
    public boolean isSubsequence(String s, String t){
        int index = -1;
        for (char c: s.toCharArray()){
            index = t.indexOf(c, index + 1);
            if (index == -1)
                return false;
        }
        return true;
    }
}
