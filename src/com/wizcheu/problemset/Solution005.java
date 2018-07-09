package com.wizcheu.problemset;

/**
 * @author wizcheu
 * @date 2018/07/09 09:40
 * @see <a href="https://leetcode.com/problems/longest-palindromic-substring/description/">https://leetcode.com/problems/longest-palindromic-substring/description/</a>
 */
public class Solution005 {

    // Your solution here...
    public String longestPalindrome(String s) {
        int length = s.length(), ans = 1;
        int[][] dp = new int[length][length];
        char[] chars = s.toCharArray();
        // border sentence
        int start = 0, end = 0, maxLength = 0;
        for (int i = 0; i < length; i++) {
            dp[i][i] = 1;
            if (i < length - 1 && chars[i] == chars[i + 1]) {
                dp[i][i + 1] = 1;
                ans = 2;
                if (maxLength < ans) {
                    maxLength = ans;
                    start = i;
                    end = i + 1;
                }
            }
        }

        // state transition equation
        for (int j = 3; j <= length; j++) {
            for (int k = 0; k + j - 1 < length; k++) {
                // the right index of the substring
                int l = k + j - 1;
                if (chars[k] == chars[l] && dp[k + 1][l - 1] == 1) {
                    dp[k][l] = 1;
                    ans = j;
                    if (maxLength < ans) {
                        maxLength = ans;
                        start = k;
                        end = l;
                    }
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for (int m = start; m <= end; m++) {
            result.append(chars[m]);
        }
        return result.toString();
    }


    public static void main(String[] args) {
        Solution005 st = new Solution005();
        System.out.println(st.longestPalindrome("cbbd"));
    }
}
