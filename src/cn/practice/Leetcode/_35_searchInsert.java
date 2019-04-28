package cn.practice.Leetcode;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 *
 * 输入: [1,3,5,6], 0
 * 输出: 0
 *
 * time:O(n)
 * space: O(1)
 * BinarySearch法(二分法)
 */
public class _35_searchInsert {
    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1,3,5,6}, 5));
        System.out.println(searchInsert(new int[]{1,3,5,6}, 2));
        System.out.println(searchInsert(new int[]{1,3,5,6}, 0));
    }
    public static int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end){
            int mid = (start + end) / 2;
            if (target == nums[mid]) return mid;
            else if (target < nums[mid]) end = mid;
            else start = mid;
        }
        // 下面的判断很重要
        // 当前插入的是最小的数字
        if (target < nums[start]){
            return start;
            // 插入的是中间的数字
        }else if (target <= nums[end]){
            return end;
        } else {
            // 当前插入的是最大的元素
            return end + 1;
        }
    }
}
