package cn.practice.Algorithm.Leetcode.before._08_PalindromeNumber;

/**
 * 判断回文数
 */
public class isPalindrome {
    public static void main(String[] args) {
        System.out.println("回文数：" + isPalindRome(121));
    }

    public static boolean isPalindRome(int x){
        // 1000末尾是0得一定不是回文数
        if (x < 0 || x !=0 && x %10 == 0)
            return false;
        int rev = 0;
        int palind = x;
        while (x > 0){
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        System.out.println(rev);
        return rev == palind;
    }
}
