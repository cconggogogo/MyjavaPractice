package cn.practice.Interview.zijietiaodong;

/**
 * 求一个给定字符串中的最长的回文字串，
 * 举例：
 * s = "abbacdaba"
 * 结果为："abba"
 */
public class Long_HuiwenNumber {
    public static void main(String[] args) {
        System.out.println(longest_huiwennumber("abbaaba"));
        System.out.println(longest_huiwennumber("abcd"));
        System.out.println(longest_huiwennumber("abcbadeef"));
        System.out.println(longest_huiwennumber("abcbadegef"));
    }
    public static String longest_huiwennumber(String s){
        int k,j,m;
        String res = "";
        for (int i = 0;i<s.length();i++){
            k = i;
            j = s.length() - 1;
            while (i<j){
                while (s.charAt(i)!=s.charAt(j)){
                    j--;
                }
                m = j;
                while (i<j&&s.charAt(i) == s.charAt(j)){
                    i++;
                    j--;
                }
                if (i>=j){
                    String temp = s.substring(k,m+1);
//                    System.out.println("i=" + k + ",temp= " + temp);
                    res = res.length()>temp.length()? res:temp;
                } else {
                    j = m-1;
                    i = k;
                }
            }

        }
        return res;
    }
}
