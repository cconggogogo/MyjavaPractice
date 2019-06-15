package cn.practice.Algorithm.myCodePractice;

import cn.practice.Tools.ListNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class _05_DoublePointer {
    public int[] getIndex(int[] nums, int target){
        int i = 0, j = nums.length - 1;
        while ( i < j ){
            if (nums[i] + nums[j] == target)
                return new int[]{i+1, j+1};
            else if (nums[i] + nums[j] < target){
                i++;
            }
            else
                j--;
        }
        return null;
    }

    public boolean judgeSquareSum(int n){
        int c = (int)Math.sqrt(n);
        int i = 0, j = c;
        while ( i <= j ){
            int res = i * i + j * j ;
            if (res == n)
                return true;
            else if (res < n){
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

    public String reverseVowels(String s){
        HashSet<Character> hashSet = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        int i = 0, j = s.length() - 1;
        char[] chs = new char[s.length()];
        while ( i <= j){
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if (!hashSet.contains(ci)){
                chs[i++] = ci;
            } else if (!hashSet.contains(cj)){
                chs[j--] = cj;
            } else {
                chs[i++] = cj;
                chs[j--] = ci;
            }
        }
        return new String(chs);
    }

    public boolean isPalind(String s, int start , int end){
        while (start < end){
            if (s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }
        return true;
    }

    public boolean validPalindome(String s){
        int i = 0, j = s.length() - 1;
        while ( i < j ){
            if (s.charAt(i) != s.charAt(j)){
                return isPalind(s,i,j-1) || isPalind(s,i+1,j);
            }
            i++;
            j--;
        }
        return true;
    }

    public void merge(int[] nums1, int[] nums2, int m , int n){
        int mn = m + n - 1;
        int index1 = m - 1;
        int index2 = n - 1;
        while (index1 >= 0 || index2 >= 0){
            if (index1 < 0){
                nums1[mn--] = nums2[index2--];
            } else if (index2 < 0){
                nums1[mn--] = nums1[index1--];
            } else if (nums1[index1] < nums2[index2] ){
                nums1[mn--] = nums2[index2--];
            } else {
                nums1[mn--] = nums1[index1--];
            }
        }
    }

    public boolean hasCrcle(ListNode head){
        if (head == null) return false;
        ListNode left = head;
        ListNode right = head.next;
        while (left != null && right != null && right.next != null){
            if (left == right)
                return true;
            left = left.next;
            right = right.next.next;
        }
        return false;
    }

    @Test
    public void test(){
        ListNode h1 = new ListNode(1);
        ListNode h2 = new ListNode(2);
        ListNode h3 = new ListNode(3);
        ListNode h4 = new ListNode(4);
        ListNode h5 = new ListNode(5);
        h1.next = h2;
        h2.next = h3;
        h3.next = h4;
        h4.next = h5;
        System.out.println(hasCrcle(h1));
    }

    public boolean isSubstr(String s, String t){
        int i = 0, j = 0;
        while ( i < s.length() && j < t.length()){
            if (s.charAt(i) == t.charAt(j)){
                j++;
            }
            i++;
        }
        return t.length() == j ;
    }

    public String findLongestWord(String s, List<String> lists){
        String longestWords = "";
        for (String item : lists){
            int l1 = item.length(), l2 = longestWords.length();
            if (l1 < l2 || (l1 == l2 && longestWords.compareTo(item) < 0))
                continue;
            if (isSubstr(s,item)){
                longestWords = item;
            }
        }
        return longestWords;
    }
}
