package cn.practice.Interview.zijietiaodong.mianshi;

/**
 * 现在有n户人家，有一个小偷要去偷东西
 * 但是小偷不能偷连续两家的东西，
 * 问？小偷最多可以偷多少钱的东西？？
 * int[] money = {1,2,3,4,5,6,7}
 * 代表第1-7户人家的钱数
 */
public class MoneyTest {
    public static void main(String[] args) {
        int[] money = {1,3,5,7,9,11,13};
        System.out.println(select(money,money.length-1));
    }

    public static int select(int[] money,int index){
        if (index == 0) return money[0];
        else if (index == 1) return Math.max(money[0],money[1]);
        else {
            return Math.max(select(money,index-1),select(money,index-2)+money[index]);
        }
    }
}
