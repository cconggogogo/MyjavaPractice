package cn.practice.Algorithm.myCodePractice;

import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * 折半插入和红白蓝不要等号，其他(快速排序)不需要
 */
public class _01_sort {
    public void insert(int[] nums){
        for (int i = 0; i < nums.length;i++){
            int temp = nums[i];
            int j = i - 1;
            while (j >= 0 && temp < nums[j]){
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = temp;
        }
    }

    public void insert2(int[] nums){
        for (int i = 1; i < nums.length; i++){
            int temp = nums[i];
            int low = 0;
            int high = i - 1;
            while (low <= high){
                int mid = (low + high) / 2;
                if (nums[mid] < temp){
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            for (int j = i - 1; j >= high + 1; j--)
                nums[j + 1] = nums[j];
            nums[high + 1] = temp;
        }
    }

    public void swap(int[] nums, int low, int high){
        int i = low, j = high;
        if (low < high){
            int temp = nums[low];
            while (i < j){
                while (i <j && nums[j] >= temp)
                    j--;
                if (i < j){
                    nums[i++] = nums[j];
                }
                while (i < j && nums[i] < temp)
                    i++;
                if (i < j){
                    nums[j--] = nums[i];
                }
            }
            nums[i] = temp;
            swap(nums,low,i-1);
            swap(nums,i+1,high);
        }
    }

    public void bubble(int[] nums){
        for (int i = 0; i< nums.length - 1; i++){
            for (int j = 0; j < nums.length - i; j++){
                if (nums[j] < nums[j + 1]){
                    swapNumber(nums,j, j+ 1);
                }
            }
        }
    }

    public void bubbleTwo(int[] nums){
        int start = 0, end = nums.length - 1;
        boolean flag = true;
        while (flag){
            flag = false;
            for (int i = start;i < end; i++){
                if (nums[i] > nums[i + 1]){
                    swapNumber(nums,i , i + 1);
                    flag = true;
                }
            }
            end--;
            for (int j = end; j > start;j--){
                if (nums[j] < nums[j - 1]){
                    swapNumber(nums, j , j - 1);
                    flag = true;
                }
            }
            start++;
        }
    }

    public void swapOldder(int[] nums){
        int i = 0, j = nums.length - 1;
        while (i < j){
            while (i < j && nums[j] % 2 == 1)
                j--;
            while (i < j && nums[i] % 2 == 0)
                i++;
            if (i < j){
                swapNumber(nums, i , j);
                i++;
                j--;
            }
        }
    }

    public void flag(int[] nums){
        int i = 0, j = 0, k = nums.length - 1;
        while (j <= k){
            switch (nums[j]){
                case 0:
                    swapNumber(nums,nums[i],nums[j]);
                    i++;
                    j++;
                    break;
                case 1:
                    j++;
                    break;
                case 2:
                    swapNumber(nums,nums[j],nums[k]);
                    k--;
                    break;
            }
        }
    }

    public int min_k(int[] nums, int low, int high, int k){
        int i = low, j = high;
        if (low < high){
            int temp = nums[low];
            while (i < j){
                while (i < j && nums[j] >= temp)
                    j--;
                if (i < j){
                    nums[i] = nums[j];
                    i++;
                }
                while (i < j && nums[i] < temp)
                    i++;
                if (i < j){
                    nums[j] = nums[i];
                    j--;
                }
            }
            nums[i] = temp;
            if (i == k - 1)
                return nums[i];
            else if (i < k - 1)
                return min_k(nums, i + 1, high, k);
            else
                return min_k(nums, low, i - 1, k);
        }
        return -1;
    }

    public void select(int[] nums){
        for (int i = 0; i < nums.length - 1; i++){
            int k = i;
            for (int j = i + 1; i < nums.length; j++){
                if (nums[j] < nums[k])
                    k = j;
            }
            swapNumber(nums,k,i);
        }
    }

    public void mergerSort(int[] nums, int low, int high){
        if (low < high){
            int mid = (low + high) / 2;
            mergerSort(nums, low, mid);
            mergerSort(nums, mid + 1, high);
        }
    }

    public void merge(int[] nums, int low, int mid, int high){
        int[] newArr = new int[nums.length];
        int i , j;
        int k;
        for (i = low; i <= high; i++)
            newArr[i] = nums[i];
        for (i = low, j = mid, k = i;i <= mid && j <= high;){
            if (newArr[i] < newArr[j]){
                nums[k++] = newArr[i];
            } else {
                nums[k++] = newArr[j];
            }
        }
        while (i <= mid){
            nums[k++] = newArr[i++];
        }
        while (j <= high){
            nums[k++] = newArr[j++];
        }
    }

    public void swapNumber(int[] nums, int start, int end){
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }

    public void bingJi(int[] arr1,int[] arr2){
        HashSet<Integer> hashSet = new HashSet<>();
        int i , j ;
        for (i = 0, j = 0; i < arr1.length && j < arr2.length; ){
            if (arr1[i] < arr2[j]){
                hashSet.add(arr1[i]);
                i++;
            } else if (arr1[i] > arr2[j]){
                hashSet.add(arr2[j]);
                j++;
            } else {
                hashSet.add(arr1[i]);
                i++;
                j++;
            }
        }
        while (i < arr1.length){
            hashSet.add(arr1[i++]);
        }
        while (j < arr2.length){
            hashSet.add(arr2[j++]);
        }
    }

    public void jiaoJi(int[] arr1, int[] arr2){
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0, j = 0; i < arr1.length && j < arr2.length; ){
            if (arr1[i] < arr2[j])
                i++;
            else if (arr1[i] > arr2[j])
                j++;
            else {
                hashSet.add(arr1[i]);
                i++;
                j++;
            }
        }
    }

    public void chaJi(int[] arr1, int[] arr2){
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0, j = 0; i < arr1.length && j < arr2.length; ){
            if (arr1[i] < arr2[j]){
                hashSet.add(arr1[i]);
                i++;
            } else if (arr1[i] > arr2[j])
                j++;
            else {
                i++;
                j++;
            }
        }
     }

     public int getMidNumber(int[] nums){
         PriorityQueue<Integer> p1 = new PriorityQueue<>((a,b) -> b - a);
         PriorityQueue<Integer> p2 = new PriorityQueue<>();
         int n = 0;
         for (int item : nums){
             if (n % 2 == 0){
                 p1.add(item);
                 p2.add(p1.poll());
             } else {
                 p2.add(item);
                 p1.add(p2.poll());
             }
             n++;
         }
         if (n % 2 == 0){
             return (p1.peek() + p2.peek()) / 2;
         } else {
             return p2.peek();
         }
     }
}
