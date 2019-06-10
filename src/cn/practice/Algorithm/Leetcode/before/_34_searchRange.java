package cn.practice.Algorithm.Leetcode.before;

import java.util.Arrays;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。
 * 找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 *
 * time:O(n)
 * space:O(1)
 */

/**
 * 注意的是二分法的基础问题：
 * 关于是向左走还是向右走的问题，取决于自己的判断语句
 */
public class _34_searchRange {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{5,7,7,8,8,10},6)));
        System.out.println(Arrays.toString(searchRange(new int[]{5,7,7,8,8,10},8)));
        System.out.println(Arrays.toString(searchRange(new int[]{5,7,7,8,8,8,0,8,8,8,8,8,8,8,10},8)));
        System.out.println(Arrays.toString(searchRange(new int[]{8,8,8,8,8},8)));

    }
    public static int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1,-1};
        int start = findFirst(nums,target);
        if (start == -1) return new int[]{-1,-1};
        int end = findLast(nums,target);
        System.out.println("start: " + start);
        System.out.println("end: " + end);
        return new int[]{start,end};
    }
    public static int findFirst(int[] nums, int target){
        int start = 0;
        int end = nums.length -1;
        while (start + 1 < end){
            int mid = (start + end) / 2;
            // 向小的方向走
            if (nums[mid] < target){
                start = mid;
            }else {
                end = mid;
            }
        }
        // 注意顺序
        if (nums[start] == target) return start;
        if (nums[end] == target) return end;
        return -1;
    }

    public static int findLast(int[] nums, int target){
        int start = 0;
        int end = nums.length -1;
        // 向大的方向走
        while (start + 1 < end){
            int mid = (start + end) / 2;
            if (nums[mid] > target){
                end = mid;
            }else {
                start = mid;
            }
        }
        // 注意顺序
        if (nums[end] == target) return end;
        if (nums[start] == target) return start;
        return -1;
    }
}
