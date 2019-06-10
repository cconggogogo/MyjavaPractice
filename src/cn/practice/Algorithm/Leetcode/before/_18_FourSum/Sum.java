package cn.practice.Algorithm.Leetcode.before._18_FourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 找出数组中4个数之和为target的组合
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 *
 * A solution set is:
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 *
 * 同ThreeSum：
 * time: O(n3)
 * space: O(n)
 */
public class Sum {
    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{1, 0, -1, 0, -2, 2},0));
    }
    public static List<List<Integer>> fourSum(int[] nums, int target){
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 4) return res;
        Arrays.sort(nums);
        for (int i = 0; i< nums.length - 3; i++){
            // 连续的两个数字就不需要再算一遍了
            if (i > 0&& nums[i] == nums[i - 1]) continue;
            for (int j = i + 1;j<nums.length - 2;j ++){
                if (j > i+1 && nums[j] == nums[j - 1]) continue;
                int low = j + 1,high = nums.length - 1;
                while (low < high){
                    int sum = nums[i] + nums[j] +nums[low] + nums[high];
                    if (sum == target){
                        res.add(Arrays.asList(nums[i],nums[j],nums[low],nums[high]));
                        // 去重
                        while (low < high && nums[low] == nums[low + 1]) low++;
                        while (low < high && nums[high] == nums[high - 1]) high--;
                        low++;
                        high--;
                    } else if (sum < target){
                        low++;
                    } else high--;
                }
            }
        }
        return res;
    }
}
