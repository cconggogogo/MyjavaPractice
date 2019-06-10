package cn.practice.Algorithm.Leetcode.cys2018._04_Binarysearch;

import org.junit.Test;

/**
 * 5. 旋转数组的最小数字（部分有序的数组中的最小值）
 *
 * 5. 旋转数组的最小数字
 */
public class _05_findMin {
    @Test
    public void test(){
//        int[] nums = {7,8,9,10,1,2,3};
//        int[] nums = {1,2,3,7,8,9,10};
        int[] nums = {1,2,3,1,2,3,4,5};
        System.out.println(findMin(nums));
    }
    public int findMin(int[] nums){
        int l = 0, h = nums.length - 1;
        while (l < h){
            int m = l + (h - l) / 2;
            if (nums[m] <= nums[h])
                h = m;
            else
                l = m + 1;
        }
        return nums[l];
    }
}
