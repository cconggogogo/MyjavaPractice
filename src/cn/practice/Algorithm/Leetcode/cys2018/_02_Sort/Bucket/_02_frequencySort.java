package cn.practice.Algorithm.Leetcode.cys2018._02_Sort.Bucket;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2. 按照字符出现次数对字符串排序
 *
 *
 * Input:
 * "tree"
 *
 * Output:
 * "eert"
 *
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 *
 */
public class _02_frequencySort {
    @Test
    public void test(){
        System.out.println(new _02_frequencySort().frencySort("tree"));
    }
    public String frencySort(String s){
        Map<Character, Integer> frequencyForNum = new HashMap<>();
        for (char c: s.toCharArray()){
            frequencyForNum.put(c,frequencyForNum.getOrDefault(c,0) + 1);
        }
        List<Character>[] frequencyBucket = new ArrayList[s.length() + 1];
        for (char c: frequencyForNum.keySet()){
            int f = frequencyForNum.get(c);
            if (frequencyBucket[f] == null)
                frequencyBucket[f] = new ArrayList<>();
            frequencyBucket[f].add(c);
        }
        StringBuilder str = new StringBuilder();
        for (int i = frequencyBucket.length - 1; i >= 0;i--){
            if (frequencyBucket[i] == null)
                continue;
            for (char c: frequencyBucket[i]){
                for (int j = 0; j < i; j++){
                    str.append(c);
                }
            }
        }
        return str.toString();
    }
}
