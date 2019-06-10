package cn.practice.Algorithm.Leetcode.cys2018._04_Binarysearch;

import org.junit.Test;

/**
 * 4. 第一个错误的版本
 *
 * 题目描述：给定一个元素 n 代表有 [1, 2, ..., n] 版本，在第 x 位置开始出现错误版本，导致后面的版本都错误。可以调用 isBadVersion(int x) 知道某个版本是否错误，要求找到第一个错误的版本。
 *
 * 如果第 m 个版本出错，则表示第一个错误的版本在 [l, m] 之间，令 h = m；否则第一个错误的版本在 [m + 1, h] 之间，令 l = m + 1。
 *
 * 因为 h 的赋值表达式为 h = m，因此循环条件为 l < h。
 *
 * Given n = 5, and version = 4 is the first bad version.
 *
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 *
 * Then 4 is the first bad version.
 */
public class _04_firstBadVersion {
    @Test
    public void test(){
        System.out.println(firstBadVersion(5));
    }
    public int firstBadVersion(int n){
        int l = 1, h = n;
        while (l < h){
            int mid = l + (h - l) / 2;
            if (isBadVersion(n, mid))
                h = mid;
            else {
                l = mid + 1;
            }
        }
        return l;
    }

    public boolean isBadVersion(int n, int mid){
        int random = 2;
//        int random = getRandom(0, n);
//        System.out.println("version: " + random);
        if (random <= mid)
            return true;
        return false;
    }

    public int getRandom(int start, int end) {
        int number = (int) (Math.random() * (end - start + 1)) + start;
        return number;
    }
}
