package cn.practice.Algorithm.Leetcode.before._05_LongestPalindrome;

/**
 * 回文数算法
 * input: "babad"
 * output: "bab","aba"
 * 给出前后读可重复的字串
 *
 * input: "cbba"
 * output: "bb"
 */



public class LongestPalindrome {
    public static void main(String[] args) {
        String s = "abadfdasfba";
        String s2 = "abadaabaa";
        System.out.println(longestPalindrome(s));
        System.out.println(longestPalindrome(s2));
        System.out.println();
        System.out.println(longestPalindrome2(s));
        System.out.println(longestPalindrome2(s2));
        System.out.println();

    }
    // a b a d a a b a a
    //               j
    // i
    /**
     * dp法
     * time: O(n^2)
     * space: O(n^2)
     */
    public static String longestPalindrome(String s){
        if (s == null || s.length() == 0) return s;
        String res = "";
        boolean[][] dp = new boolean[s.length()][s.length()];
        int max = 0;
        /**
         *  举例：
         *  a b a a b
         *    i     j
         *  i和j向中间走
         */
        for (int j = 0;j<s.length();j++){
            for (int i = 0;i<=j;i++){
                // j-i<=2后面的语句就不需要做了
                // 注意dp[i+1][j-1]的作用，类似于递归，下面这个思路很重要
                dp[i][j] = s.charAt(i) == s.charAt(j) && ((j-i<=2) ||dp[i+1][j-1]);
                if (dp[i][j]){
                    // 当前j-i之间的字串更长，更新字串
                    if (j-i+1 > max){
                        max = j-i+1;
                        res = s.substring(i,j+1);
                    }
                }
            }
        }
        System.out.println("max: " + max);
        return res;
    }

    /**
     * dp法
     * time: O(n^2)
     * space: O(n^2)
     */
    // a b a b a b
    //     i
    //       i
    static String res = "";
    public static String longestPalindrome2(String s){
        res = "";
        if (s == null || s.length() == 0) return s;
        for (int i = 0;i<s.length();i++){
            // 向两侧延申，分奇数偶数两种情形：a b a与a b b a
            helper(s,i,i);
            helper(s,i,i+1);
        }
        return res;
    }

    public static void helper(String s,int left, int right){
        while (left >=0 && right <s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        String cur = s.substring(left+1,right);
        if (cur.length() > res.length()){
            res = cur;
        }
    }
}
