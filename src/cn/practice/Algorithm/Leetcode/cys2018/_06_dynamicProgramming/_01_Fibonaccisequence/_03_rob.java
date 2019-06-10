package cn.practice.Algorithm.Leetcode.cys2018._06_dynamicProgramming._01_Fibonaccisequence;

/**
 3. 强盗在环形街区抢劫
 */
public class _03_rob {
    public int rob(int[] nums){
        if (nums == null || nums.length == 0)
            return 0;
        int n = nums.length;
        if (n == 1)
            return nums[0];
        return Math.max(rob(nums,0,n-2),rob(nums,1,n-1));
    }
    public int rob(int[] nums, int first, int last){
        int pre2 = 0, pre1 = 0;
        for (int i = first; i <= last;i++){
            int cur = Math.max(pre2 + nums[i], pre1);
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }
}
