package cn.practice.Leetcode._12_IntegerToRoman;

public class IntegerToRoman {
    public static void main(String[] args) {
        // 65 = 50 + 10 + 5
        //      L     X   V
        System.out.println(intToRoman(65));
    }

    /**
     * time: O(n)
     * space: O(n),StringBuilder，所以是O(n)
     * @param num
     */
    public static String intToRoman(int num){
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] str = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i<values.length;i++){
            while (num >= values[i]){
                num-=values[i];
                sb.append(str[i]);
            }
        }
        return sb.toString();
    }
}
