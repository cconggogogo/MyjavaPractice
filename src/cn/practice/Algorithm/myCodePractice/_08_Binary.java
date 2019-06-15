package cn.practice.Algorithm.myCodePractice;

public class _08_Binary {
    public int binarySearch(int[] nums, int k){
        int l = 0, r = nums.length - 1;
        while (l <= r){
            int mid = l + (r-l)/2;
            if (nums[mid] == k){
                return mid;
            } else if (nums[mid] < k){
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    public int mySqrt(int x){
        if (x <= 1)
            return x;
        int l = 1, r = x;
        while ( l < r){
            int mid = l + (r-l)/2;
            int value = x / mid;
            if (mid == value)
                return mid;
            else if (mid < value){
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }
}
