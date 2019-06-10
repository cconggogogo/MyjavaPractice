package cn.practice.Algorithm.Leetcode.cys2018._01_DoublePointer;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 3. 反转字符串中的元音字符
 *
 *     Given s = "leetcode", return "leotcede".
 *    given: e e o e     return e o e e
 *
 *    使用双指针指向待反转的两个元音字符，一个指针从头向尾遍历，一个指针从尾到头遍历。
 *
 */
public class _03_reverseVowels {
    @Test
    public void test(){
        System.out.println(new _03_reverseVowels().reverseVowels("leetcode"));
    }
    public String reverseVowels(String s){
        HashSet<Character> hashSet = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        int i = 0, j = s.length() - 1;
        char[] result = new char[s.length()];
        while (i <= j){
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if (!hashSet.contains(ci))
                result[i++] = ci;
            else if (!hashSet.contains(cj))
                result[j--] = cj;
            else {
                result[i++] = cj;
                result[j--] = ci;
            }
        }
        return new String(result);
    }
}
