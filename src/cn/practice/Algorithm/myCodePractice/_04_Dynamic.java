package cn.practice.Algorithm.myCodePractice;

public class _04_Dynamic {
    public int method(int n){
        if (n <= 2){
            return n;
        }
        return method(n - 1) + method(n - 2);
    }

    public int cow(int n){
        if (n <= 3){
            return n;
        }
        return cow(n - 1) + cow(n - 3);
    }

    public int robbery(int[] nums, int start, int end){
        if (start == end){
            return nums[start];
        } else if (start + 1 == end){
            return Math.max(nums[start],nums[end]);
        } else {
            return Math.max(robbery(nums,start,end - 1),robbery(nums,start,end - 2) + nums[end]);
        }
    }

    public int robberyCicycle(int[] nums){
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(robbery(nums,0,nums.length-2),robbery(nums,1,nums.length-1));
    }
}
