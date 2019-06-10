package cn.practice.Algorithm.feibolaqi;

/**
 * 环形街区抢劫
 * return Math.max(res(nums, 0, nums.length - 2), res(nums, 1, nums.length - 1));
 * 主要是考虑第一个元素和最后一个元素的情况即可！！！！！！！！！！！！！！！！
 */
public class RobberyCirycle {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println(getMax(nums));
    }
    public static int getMax(int[] nums){
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        return Math.max(res(nums, 0, nums.length - 2), res(nums, 1, nums.length - 1));
    }
    public static int res(int[] nums, int start, int end){
        // 只有一家的情况
        if (start == end)
            return nums[start];
        // 有两家的情况
        else if (start + 1 == end)
            return Math.max(nums[start], nums[end]);
        else {
            return Math.max(nums[end] + res(nums,start,end - 2), res(nums,start,end - 1));
        }
    }
}
