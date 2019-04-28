package cn.practice.Leetcode._04_MedianofTwoSortedArrays;

/**
 * 求中位数：
 * time: O(log(min(m,n)))
 * space:O(1)
 *
 * 案例：
 * index: 0  1  2  3  4  5
 * num1:  3  5  8  9          4 cut1
 * num2:  1  2  7  10 11 12   6 cut2
 * num3:  1 2 3 5 7 | 8 9 10 11 12
 */
public class _04_MedianofTwoSortedArrays {
    public static void main(String[] args) {
//        int[] nums1 = {3,5,8,9};
//        int[] nums2 = {1,2,7,10,11,12};
//        System.out.println(findMedianofSortedArrays(nums1,nums2));
//        System.out.println();
//        int[] nums5 = {5,8,10,14};
//        int[] nums6 = {1,2,3,6,9,15};
//        System.out.println(findMedianofSortedArrays(nums5,nums6));
//        System.out.println();
//        int[] nums3 = {5,8,10,14};
//        int[] nums4 = {1,2,11,13,14,15};
//        System.out.println(findMedianofSortedArrays(nums3,nums4));
//        int[] nums7 = {1,3,5,7,9};
//        int[] nums8 = {2,4,6,8,10};
//        System.out.println(findMedianofSortedArrays(nums7,nums8));
        int[] nums9 = {1,7,9,10};
        int[] nums10 = {2,5,6,13};
        System.out.println(findMedianofSortedArrays(nums9,nums10));


    }

    public static double findMedianofSortedArrays(int[] nums1,int[] nums2){
        if (nums1.length > nums2.length)
            return findMedianofSortedArrays(nums2,nums1);
        int len = nums1.length + nums2.length;
        int cut1 = 0; // 中间的位置
        int cut2 = 0;// 中间的位置
        int cutL = 0;
        int cutR = nums1.length;
        while (cut1 <= nums1.length){
            cut1 = (cutR - cutL)/2 + cutL; // 其实就是mid=(cutL + cutR) / 2;
            System.out.println("cut1: " + cut1);
            cut2 = len/2 -cut1;
            double L1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            double L2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
            double R1 = (cut1 == nums1.length) ? Integer.MAX_VALUE : nums1[cut1];
            double R2 = (cut2 == nums2.length) ? Integer.MAX_VALUE : nums2[cut2];
            System.out.println(L1);
            System.out.println(L2);
            System.out.println(R1);
            System.out.println(R2);
            // 直接返回到的情况：
            // L1<=R2,L2<=R1
            // L1 > R2，比如：1 7 9 10 与 2 5 6 13，那么9 10 就不可能了
            if (L1 > R2){
                cutR = cut1 - 1;
                // L2 > R1，比如：2 5 6 13 与 1 7 9 10，那么2 5就不可能了
            }else if (L2 > R1){
                cutL = cut1 + 1;
            }else {
                if (len % 2 == 0){
                    L1 = L1 > L2 ? L1 : L2;
                    R1 = R1 <R2 ? R1 : R2;
                    return (L1 + R1) /2;
                } else {
                    R1 = (R1 < R2) ? R1 : R2; // 取较小者
                    return R1;
                }
            }
        }
        return -1;
    }
}
