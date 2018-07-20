package com.wizcheu.problemset;

/**
 * @author wizcheu
 * @date 2018/07/20 15:33
 * @see <a href="https://leetcode.com/problems/word-search/description/">https://leetcode.com/problems/word-search/description/</a>
 */
public class Solution079 {

    // Your solution here
    public boolean exist(char[][] board, String word) {
        boolean[][] isVisited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (bfs(board, word, i, j, 0, isVisited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean bfs(char[][] board, String word, int row, int column, int index, boolean[][] isVisited) {
        int[] dh = {0, 1, 0, -1};  //检索方向[右,下,左,上]
        int[] dw = {1, 0, -1, 0};
        if (row < 0 || row >= board.length || column < 0 || column >= board[0].length || isVisited[row][column] || board[row][column] != word.charAt(index)) {
            return false;
        }
        if (++index == word.length()) {
            return true;
        }
        isVisited[row][column] = true;
        for (int i = 0; i < 4; i++) {
            if (bfs(board, word, row + dh[i], column + dw[i], index, isVisited)) {
                return true;
            }
        }
        isVisited[row][column] = false;
        return false;
    }

    public static void main(String[] args) {
        Solution079 st = new Solution079();
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";
        System.out.println(st.exist(board, word));
    }
}