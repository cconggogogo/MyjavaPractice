package cn.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 串联所以单词的字串
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 *
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 *
 * 示例 1：
 *
 * 输入：
 *   s = "barfoothefoobarman",
 *   words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoor" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 *
 *
 * 示例 2：
 *
 * 输入：
 *   s = "wordgoodgoodgoodbestword",
 *   words = ["word","good","best","word"]
 * 输出：[]
 *
 * time:O(n^2)
 * space:O(n)
 */
public class _30_findSubstring {
    public static void main(String[] args) {
        System.out.println(findSubstring("wordgoodgoodgoodbestword",new String[]{"word","good","best","word"}).toString());
        System.out.println(findSubstring("foobar jdbarfoo",new String[]{"foo","bar"}).toString());

    }
    public static List<Integer> findSubstring(String s,String[] words){
        if (s == null || words == null) return  new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        int n = words.length;
        // 单词都是一样的大小
        int m = words[0].length();
        HashMap<String,Integer> map = new HashMap<>();
       // {bar=1, foo=1},统计个数，如果有的话就是value的值+1，如果没用的话就是默认值0+1
        for (String str: words){
            map.put(str,map.getOrDefault(str,0) + 1);
        }
        for (int i = 0; i <=s.length() - n*m ;i++){
            HashMap<String,Integer> copy = new HashMap<>(map);
            int k = n; // words的数目
            int j = i; // 开始遍历的位置
            while (k > 0){
                String str = s.substring(j, j + m);
                // copy.get(str) < 1说明words中根本就没用这个单词
                if (!copy.containsKey(str) || copy.get(str) < 1){
                    break;
                }
                copy.put(str,copy.get(str) - 1);
                k--;
                j += m;
            }
            if (k == 0) res.add(i);
        }
        return res;
    }
}
