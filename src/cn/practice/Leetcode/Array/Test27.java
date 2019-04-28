package cn.practice.Leetcode.Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * 输入n个字符
 * 获得这n个字符得全排列组合
 * 比如输入a,b,c
 * 得到一共6种
 */

/**
 * 分析，比如：
 * 已知了两个数得全排怎么做呢
 */
public class Test27 {

    public ArrayList<String> Permutation(String str){

        ArrayList<String> list = new ArrayList<String>();
        if(str!=null && str.length()>0){
            PermutationHelper(str.toCharArray(),0,list);
            Collections.sort(list);
        }
        return list;
    }
    private void PermutationHelper(char[] chars, int i, ArrayList<String> list){
        if(i == chars.length-1){
            list.add(String.valueOf(chars));
        }else{
            Set<Character> charSet = new HashSet<Character>();
            for(int j=i;j<chars.length;++j){
                if(j==i || !charSet.contains(chars[j])){
                    charSet.add(chars[j]);
                    swap(chars,i,j);
                    PermutationHelper(chars,i+1,list);
                    swap(chars,j,i);
                }
            }
        }
    }
    private void swap(char[] cs,int i,int j){
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }

    public static void main(String[] args) {
        Test27 test27 = new Test27();
        ArrayList<String> arrayList = test27.Permutation("abc");
        for (int x = 0;x<arrayList.size();x++) {
            System.out.println(arrayList.get(x));
        }
    }
}
