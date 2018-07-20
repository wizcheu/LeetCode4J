package com.wizcheu.problemset;

/**
 * @author wizcheu
 * @date 2018/07/18 20:24
 * @see <a href="https://leetcode.com/problems/minimum-path-sum/">https://leetcode.com/problems/minimum-path-sum/</a>
 */
public class Solution064 {

    // Your solution here
    public int minPathSum(int[][] grid) {
        if (null == grid || 0 == grid.length || 0 == grid[0].length) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Solution064 st = new Solution064();
        int[][] grid = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}};
        System.out.println(st.minPathSum(grid));
    }
}