package cn.practice.Leetcode._09_IsMatch;

public class IsMatch {
    /**
     * dp类型的题目
     * @param args
     *
     * 大意："."代表任意单个字符
     * "*"代表任意个之前出现的字符
     * 举例：
     * isMatch("ab",".*"):true;
     * isMatch("aab","c*a*b"):true;
     *
     * time: O(m * n)
     * space:O(m * n)
     */

    /**
     * @param args
     *
     * 分析：
     * 1.p.charAt(j)==s.charAt(i):dp[i][j]=dp[i-1][j-1]
     * 2.If p.charAt(j)=='.':dp[i][j]=dp[i-1][j-1]不需要看s的字符了
     * 3.If p.charAt(j)=='*':
     *  1.p.charAt(j-1)!=s.charAt(i):dp[i][j]=dp[i][j-2]
     *  指的是：aab 与 bc*aab,在*的位置，只需要看b的状态
     *  2.p.charAt(j-1)==s.charAt(i) or p.charAt(j-1)=='.'
     *      dp[i][j]=dp[i][j-1] aa a*,*代表一个a
     *      dp[i][j]=dp[i-1][j] aaa a*，代表两个a
     *      dp[i][j]=dp[i][j-2] empty aaa a*aaa的时候
     */
    public static void main(String[] args) {
        System.out.println(isMatch("ab",".*"));
        System.out.println(isMatch("ab",".***"));
        System.out.println(isMatch("aab","c*a*b"));
        System.out.println(isMatch("aaa","a*"));
        System.out.println(isMatch("aaaaaaaaaa","a*"));
//        System.out.println(isMatch("ab","ab"));
    }

    // boolean dp[i][j]的含义是：
    // s[0-i]与p[0-j]是否匹配
    // 举例：dp[3][4]:指的是：s[0-3]与p[0-4]是否匹配
    public static boolean isMatch(String s ,String p){
        if (s == null || p == null) return false;
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;// 不代表任何元素的处理

        for (int i = 0; i<p.length();i++){
            // 说的是:"aab","c*a*b"这种情况
            if (p.charAt(i) == '*' && dp[0][i-1]){
                dp[0][i + 1] = true; // 把c*删除，dp[0][2]=true
            }
        }
        for (int i = 0; i < s.length(); i++){
            for (int j = 0; j < p.length(); j++){
                // 完全相同的情况
                if (p.charAt(j) == s.charAt(i)){
                    // 当前是合理的，只和之前的结果有关
                    dp[i + 1][j + 1] = dp[i][j];
                }
                // aaaa 与 aaa.这种情况
                if (p.charAt(j) == '.'){
                    dp[i + 1][j + 1] = dp[i][j];
                }
                /**
                 * 3.If p.charAt(j)=='*':
                 *      1.p.charAt(j-1)!=s.charAt(i):dp[i][j]=dp[i][j-2]
                 *      指的是：aab 与 bc*aab,在*的位置，只需要看b的状态
                 *      2.p.charAt(j-1)==s.charAt(i) or p.charAt(j-1)=='.'
                 *           dp[i][j]=dp[i][j-1] aa a*,*代表一个a
                 *           dp[i][j]=dp[i-1][j] aaa a*，代表两个a
                 *           dp[i][j]=dp[i][j-2] empty aaa a*aaa的时候
                 */
                if (p.charAt(j) == '*'){
                    // 指的是：aab 与 bc*aab,在*的位置，只需要看b的状态
                    if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.'){
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    }else { // 指的是：
                        dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1]);
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
