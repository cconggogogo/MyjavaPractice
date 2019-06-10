package cn.practice.Algorithm.Leetcode.cys2018._04_Binarysearch;

import org.junit.Test;

import java.util.Arrays;

/**
 * 6. 查找区间
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 *
 *
 */
public class _06_searchRange {
    @Test
    public void test(){
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        System.out.println(Arrays.toString(searchRange(nums,target)));
    }
    public int[] searchRange(int[] nums, int target){
        int first = binarySearch(nums,target);
        int last = binarySearch(nums,target + 1) - 1;
        if (first == nums.length || nums[first] != target)
            return new int[]{-1,-1};
        else
            return new int[]{first, Math.max(first,last)};
    }

    public int binarySearch(int[] nums, int target){
        int l = 0, h = nums.length;
        while (l < h){
            int m = l + (h - l) /2;
            if (nums[m] >= target){
                h = m ;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}
