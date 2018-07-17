package com.wizcheu.problemset;

/**
 * @author wizcheu
 * @date 2018/07/16 21:37
 * @see <a href="https://leetcode.com/problems/rotate-image/description/">https://leetcode.com/problems/rotate-image/description/</a>
 */
public class Solution048 {

    // Your solution here
    public void rotate(int[][] matrix) {
        if (null == matrix || 0 == matrix.length) {
            return;
        }
        int width = matrix.length;
        for (int i = 0; i < width / 2; i++) {
            for (int j = i; j < width - 1 - i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[width - 1 - j][i];
                matrix[width - 1 - j][i] = matrix[width - 1 - i][width - 1 - j];
                matrix[width - 1 - i][width - 1 - j] = matrix[j][width - 1 - i];
                matrix[j][width - 1 - i] = temp;
            }
        }
    }

    private void print2DMatrix(int[][] matrix) {
        int width = matrix.length;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Solution048 st = new Solution048();
        int[][] matrix = new int[][]{
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}};
        st.rotate(matrix);
    }
}