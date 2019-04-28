package cn.practice.Leetcode._10_ContainerWaterMost;

/**
 * 给一个数组，问最多可以装多少水
 * time: O(n)
 * space: O(1)
 */
public class Container {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,2,3,4,5,6,7}));
    }
    public static int maxArea(int[] height){
        int res = 0;
        int l = 0, r = height.length - 1;
        int ltemp = 0,rtemp = 0,resTemp = 0, heightTemp = 0;
        while (l < r) {
            resTemp = res;
            res = Math.max(res,Math.min(height[l],height[r]) * (r - l));
            if (resTemp!=res){
                ltemp = l;
                rtemp = r;
                heightTemp = height[l] < height[r] ? height[l]: height[r];
            }
            if (height[l] < height[r]){
                l ++ ;
            } else {
                r--;
            }
        }
        System.out.println("l: " + ltemp + ", r: " + rtemp + "," + "heigh: " + heightTemp);
        return res;
    }
}
