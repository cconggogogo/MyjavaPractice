package cn.practice.Algorithm.Leetcode.before.Array;
/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 *         每一列都按照从上到下递增的顺序排序。请完成一个函数，
 *         输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */

/**
 * 分析：从左下角的元素开始判断，比她小就往上
 * 比他大就往右
 */
public class Test1 {
    public static void main(String[] args) {
        int[][] arr = {{1,10,20,30},{3,11,23,34},{5,15,26,36}};
        printArr(arr);
        System.out.println(Find(30,arr));
    }
    public static void printArr(int[][] arr){
        for (int x=0;x<arr.length;x++){
            for (int y=0;y<arr[x].length;y++){
                if (y==arr[x].length-1){
                    System.out.println(arr[x][y]);
                } else {
                    System.out.print(arr[x][y] + "  ");
                }
            }
        }
    }
    public static boolean Find(int target, int [][] array) {
        int colsSize = array.length;
        int rowsSize = array[0].length;
        int i,j;
        for(i=colsSize-1,j=0;i>=0&&j<=rowsSize-1;){
            if(target == array[i][j])
                return true;
            else if(target>array[i][j])
                j++;
            else
                i--;
        }
        return false;
    }
}
