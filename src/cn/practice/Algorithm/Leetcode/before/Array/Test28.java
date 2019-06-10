package cn.practice.Algorithm.Leetcode.before.Array;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 * 如果不存在则输出0。
 */

/**
 * 找到主元素
 */
public class Test28 {
    public int MoreThanHalfNum_Solution(int [] array) {
        int length=array.length;
        if(array==null||length<=0){
            return 0;
        }

        if(length==1){
            return array[0];
        }

        int[] tempArray=new int[length];
        for(int i=0;i<length;i++){
            tempArray[i]=array[i];
        }

        for(int i=0;i<length;i++){
            //后面需要用零来代表抹除数字，所以对0时做特殊处理
            if(tempArray[i]==0){
                continue;
            }

            for(int j=i+1;j<length;j++){
                if(tempArray[i]!=tempArray[j]&&tempArray[j]!=0){
                    tempArray[i]=0;//此处用0代表抹去该数字
                    tempArray[j]=0;
                    break;
                }

            }
        }

        //找出未被抹去的数字
        int result=0;
        for(int i=0;i<length;i++){
            if(tempArray[i]!=0){
                result=tempArray[i];
                break;
            }
        }

        int times=0;
        for(int i=0;i<length;i++){
            if(result==array[i]){

                times++;
            }
        }

        if(times*2<length){
            result=0;
        }
        return result;
    }

    public int MoreThanHalfNum_Solution2(int [] array) {
        int length=array.length;
        if(array==null||length<=0){
            return 0;
        }

        int result=array[0];
        int times=1;
        for(int i=1;i<length;i++){
            if(times==0){
                result=array[i];
                times=1;
            }else{
                if(array[i]==result){
                    times++;
                }else{
                    times--;
                }
            }
        }

        times=0;
        for(int i=0;i<length;i++){
            if(result==array[i]){
                times++;
            }
        }

        if(times*2<length){
            result=0;
        }
        return result;
    }

    public int majority(int[] arr, int n) {
        int i,c,count=-1;
        c=arr[0];
        for (i=1;i<n;i++) {
            if (arr[i] ==c )
                count++;
            else{
                if (count>0)
                    count--;
                else {
                    c=arr[i];
                    count=1;
                }
            }
        }
        if (count>0) {
            for (i=count=0;i<n;i++)
                if (arr[i]==c)
                    count++;
        }
        if (count>n/2)
            return c;
        else
            return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,2,2,2,5,4,2};
        Test28 test28 = new Test28();
        System.out.println(test28.MoreThanHalfNum_Solution(arr));
        System.out.println(test28.majority(arr,arr.length));
    }

}




