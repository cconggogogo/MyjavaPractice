package cn.practice.Interview.zijietiaodong;

/**
 * 最长回文子串
 */
public class LongestPalindromicSubstring {
    /**
     * 中心扩展法
     */
    public String longestPalindrome2(String s) {
        // 保存获得的最大回文子串
        String maxStr = "";
        int len = s.length();

        for(int i=0; i<len; ++i) {
            String subStr1 = isPalindrome(s, i, i);

            if (subStr1.length() > maxStr.length()) {
                maxStr = subStr1;
            }
            String subStr2 = isPalindrome(s, i, i+1);

            if (subStr2.length() > maxStr.length()) {
                maxStr = subStr2;
            }
        }

        return maxStr;
    }

    private String isPalindrome(String s, int i, int j) {
        // i 表示中心扩展的左边字符
        // j 表示中心扩展的右边字符
        int len = s.length();
        while (i >= 0 && j < len && s.charAt(i) == s.charAt(j)) {
            --i;
            ++j;
        }

        return  s.substring(i+1, j);
    }


    /**
     * 暴力解法
     * 时间复杂度: $O(n^3)$
     */
    public String longestPalindrome(String s) {
        // 保存得到的最长回文子串的起始位置
        int left = 0, right = 0;
        int len = s.length();

        for (int i=0; i<len; ++i) {
            for (int j=i; j<len; ++j) { // 总是截取i到j+1范围内的字符字串来判断
                // 获取 s 的连续子串
                String subStr = s.substring(i, j+1);

                // 判断子串是否是回文字符串
                if (isPalindrome(subStr)) {
                    if (j-i > right-left) {
                        left = i;
                        right = j;
                    }
                }

            }
        }

        return s.substring(left, right+1);
    }

    private boolean isPalindrome(String s) {
        int len = s.length();
        int left = 0, right = len-1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            ++left;
            --right;
        }

        return true;
    }
}
