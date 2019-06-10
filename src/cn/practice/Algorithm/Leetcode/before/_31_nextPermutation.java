package cn.practice.Algorithm.Leetcode.before;

/**
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * 输出下一个更大的数
 *
 * time:O(n)
 * space:O(1)
 */

import java.util.Arrays;

/**
 * 1 2 7 4 3 1
 *
 */
public class _31_nextPermutation {
    public static void main(String[] args) {
        int[] nums = {1,2,7,4,3,1};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
        int[] nums2 = {7,4,3,1};
        nextPermutation(nums2);
        System.out.println(Arrays.toString(nums2));
    }
    public static void nextPermutation(int[] nums){
        if (nums == null || nums.length == 0) return;
        int firstSmall = -1;
        for (int i = nums.length - 2; i >=0; i--){
            if (nums[i] < nums[i + 1]){
                firstSmall = i;
                break;
            }
        }
        if (firstSmall == -1){
            reverse(nums, 0, nums.length - 1);
            return;
        }
        int firstLarge = -1;
        for (int i = nums.length - 1; i > firstLarge; i--){
            if (nums[i] > nums[firstSmall]){
                firstLarge = i;
                break;
            }
        }
        swap(nums,firstSmall, firstLarge);
        reverse(nums, firstSmall + 1, nums.length - 1);
        return;
    }

    private static void reverse(int[] nums, int i, int j) {
        while (i < j){
            swap(nums,i++, j--);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
