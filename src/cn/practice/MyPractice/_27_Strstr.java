package cn.practice.MyPractice;

/**
 * 找字串在主串首次出现得位置
 */
public class _27_Strstr {
    public static void main(String[] args) {
        System.out.println(strstr("helloworld","llo"));
    }
    public static int strstr(String s, String str){
        if (str.length() == 0) return 0;
        for (int i = 0; i <= s.length() - str.length(); i++){
            if (s.substring(i, i+str.length()).equals(str))
                return i;
        }
        return -1;
    }
}
