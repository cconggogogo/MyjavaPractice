package cn.practice.Algorithm.Leetcode.before._25RemoveDumplicates;

/**
 * given input array nums = [1,1,2,2,3,4,5,6]
 * result: [1,2,3,4,5,6] 6个
 *
 * time:O(n)
 * space:O(1)
 */
public class RemoveDumplicates {
    public static void main(String[] args) {
        System.out.println(removeDumplicates(new int[]{1,1,2,2,3,4,5,6}));
    }

    public static int removeDumplicates(int[] nums){
        if (nums == null || nums.length == 0) return 0;
        int connt = 1;
        for (int i = 1;i < nums.length; i++){
            if (nums[i-1] != nums[i]){
                nums[connt++] = nums[i];
            }
        }
        return connt;
    }
}
