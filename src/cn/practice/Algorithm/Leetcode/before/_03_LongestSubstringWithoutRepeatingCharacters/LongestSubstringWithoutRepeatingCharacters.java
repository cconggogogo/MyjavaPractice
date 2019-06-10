package cn.practice.Algorithm.Leetcode.before._03_LongestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 返回最长的无重复元素的字符串，比如：
 * "abcabcbb":anwer:"abc",length:3;
 * "bbbbbb":answer:"b",length:1
 * time:O(n)
 * space:O(n)
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring(("abcabcbb")));
        System.out.println(lengthOfLongestSubstring2(("abcabcbb")));
        System.out.println("------------------------");
        System.out.println(lengthOfLongestSubstring(("abbbbaabcabdvfvfddsfdsfaaadfdffabbba")));
        System.out.println(lengthOfLongestSubstring2(("abbbbaabcabdvfvfddsfdsfaaadfdffabbba")));
        System.out.println("------------------------");
        System.out.println(lengthOfLongestSubstring(("abcaadef")));
        System.out.println(lengthOfLongestSubstring2(("abcaadef")));
        System.out.println("------------------------");
        System.out.println(lengthOfLongestSubstring(("aaabbabb")));
        System.out.println(lengthOfLongestSubstring2(("aaabbabb")));
        System.out.println("------------------------");
        System.out.println(lengthOfLongestSubstring(("aaabbabb")));
        System.out.println(lengthOfLongestSubstring2(("aaabbabb")));
        System.out.println("------------------------");
        System.out.println(lengthOfLongestSubstring(("abcccef")));
        System.out.println(lengthOfLongestSubstring2(("abcccef")));
        System.out.println("------------------------");


    }
    // a b c a b c b b
    //       i
    //   j

    public static int lengthOfLongestSubstring(String s){
        if (s==null || s.length()==0) return 0;
        HashMap<Character,Integer> map = new HashMap<>();
        int res = 0;
        // i是遍历的元素的位置，j是不重复的起点是再哪里
        // j每次都会跳到重复元素的新位置
        for (int i = 0,j=0;i<s.length();i++){
            // 这里很重要的思想
            if (map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            res = Math.max(res,i-j+1);
        }
        return res;
    }
    // a a a b b a b b
    //         i
    //       j
    public static int lengthOfLongestSubstring2(String s){
        if (s==null || s.length()==0) return 0;
        HashSet<Character> set = new HashSet<>();
        int res = 0;
        for (int i = 0,j = 0;i<s.length();i++){
            // 把重复的都去掉，跳到重复元素的下一个位置(就是一定要把重复元素去掉)
            while (set.contains(s.charAt(i))){ // 看清是while，不是if
                set.remove(s.charAt(j++));
            }
            set.add(s.charAt(i));
            res = Math.max(res, set.size());
        }
        return res;
    }
}
