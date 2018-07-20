package com.wizcheu.problemset;

/**
 * @author wizcheu
 * @date 2018/07/18 19:15
 * @see <a href="https://leetcode.com/problems/unique-paths/description/">https://leetcode.com/problems/unique-paths/description/</a>
 */
public class Solution062 {

    // Your solution here
    public int uniquePaths(int m, int n) {
        if (m < 1 || n < 1) {
            return 1;
        }
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (0 == i || 0 == j) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];

    }

    public static void main(String[] args) {
        Solution062 st = new Solution062();
        System.out.println(st.uniquePaths(7, 3));
    }
}