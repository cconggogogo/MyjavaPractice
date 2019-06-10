package cn.practice.Algorithm.Leetcode.cys2018._03_GreedyAlgorithm;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 2. 不重叠的区间个数
 *
 * 题目描述：计算让一组区间不重叠所需要移除的区间个数。
 *
 * 先计算最多能组成的不重叠区间个数，然后用区间总个数减去不重叠区间的个数。
 *
 * 在每次选择中，区间的结尾最为重要，选择的区间结尾越小，留给后面的区间的空间越大，那么后面能够选择的区间个数也就越大。
 *
 * 按区间的结尾进行排序，每次选择结尾最小，并且和前一个区间不重叠的区间。
 *
 * Input: [ [1,2], [1,2], [1,2] ]
 *
 * Output: 2
 *
 * Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.
 *
 * Input: [ [1,2], [2,3] ],不算是重叠的
 *
 * Output: 0
 *
 * Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
 *
 */
public class _02_eraseOverlapIntervals {
    @Test
    public void test(){
        int[][] intervals = {{1,2},{2,3},{3,5},{2,6},{5,7},{6,8}};
        System.out.println(eraseOverlapIntervels(intervals));
    }
    public int eraseOverlapIntervels(int[][] intervals){
        if (intervals.length < 2){
            return 0;
        }
        int toRemove = 0;
        Arrays.sort(intervals,(a,b) -> a[0] - b[0]);
        int max = intervals[0][1];
        for (int i = 1; i < intervals.length; i++){
            if (intervals[i][0] < max){
                toRemove++;
                max = Math.min(max, intervals[i][1]);
            } else {
                max = intervals[i][1];
            }
        }
        return toRemove;
    }
}
