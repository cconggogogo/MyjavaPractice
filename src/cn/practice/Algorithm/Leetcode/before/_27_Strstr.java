package cn.practice.Algorithm.Leetcode.before;

/**
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，
 * 在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
 * 如果不存在，则返回  -1。
 *
 * 示例 1:
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 *
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 *
 * time：O（n2）
 * space:O(1)
 */
public class _27_Strstr {
    public static void main(String[] args) {
        System.out.println(strStr("hello","el"));
        System.out.println(strStr("hello","djof"));
    }
    public static int strStr(String haystack,String needle){
        if (needle.length() == 0) return 0;
        for (int i = 0;i <=haystack.length() - needle.length();i++){
            // 截取相同的长度，对比即可
            if (haystack.substring(i,i+needle.length()).equals(needle)) return i;
        }
        return -1;
    }
}
