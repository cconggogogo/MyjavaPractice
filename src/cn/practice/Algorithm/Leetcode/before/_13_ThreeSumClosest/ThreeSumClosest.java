package cn.practice.Algorithm.Leetcode.before._13_ThreeSumClosest;

import java.util.Arrays;

/**
 * for example :
 * given array = {-1,2,1,-4}
 * target = 1;
 * the sum that is closest to the target
 * -1 + 2 + 1 = 2 is closest to target(1)
 * 不要求连续的三个数
 *
 * time:O(n2)
 * space:O(1)
 */
public class ThreeSumClosest {
    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1,2,1,-4},1));
        System.out.println(threeSumClosest(new int[]{-1,2,1,-4,2,5,9,-1,4,-2},0));
    }

    public static int threeSumClosest(int[] nums, int target){
        int res = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for (int i = 0; i<nums.length - 1;i++){
            // 对于每一个元素都轮询，查找后面的两个数加上当前这个数可能的最小值
            // bianli
            int start = i + 1, end = nums.length - 1;
            while (start < end){
                int sum = nums[i] + nums[start] + nums[end];
                if (sum > target){
                    end --;
                }else {
                    start ++;
                }
                if (Math.abs(sum - target) < Math.abs(res - target)){
                    res = sum;
                }
            }
        }
        return res;
    }
}
