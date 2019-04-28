package cn.practice.Leetcode._06_Convert;

/**
 * input: "PAYPALISHIRING"
 * 摆放：
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * output: "PAHNAPLSIIGYIR"
 *
 * 规律：4个是一组
 */

/**
 * A
 * B   F
 * C E
 * D
 * 第一行和最后一行没有：2 * numRows - 2
 */
public class Convert {
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING",3));
        System.out.println(convert("ABCDEFGHIJ",4));
    }
    public static String convert(String s,int numRows){
        if (numRows <=1) return s;
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0;i<sb.length;i++){
            sb[i] = new StringBuilder("");
        }
        for (int i = 0;i < s.length(); i++){
            // 2 * numRows - 2是指的是几个数是一组的
            int index = i % (2 * numRows - 2);
            /**
             * A
             * B   F
             * C E
             * D
             * A B C D就是正常顺序
             * EF就是逆序
             */
            index = index < numRows ? index : 2 * numRows - 2 - index;
            sb[index].append(s.charAt(i));
        }
        for (int i = 1; i< sb.length;i++){
            sb[0].append(sb[i]);
        }
        return sb[0].toString();
    }
}
