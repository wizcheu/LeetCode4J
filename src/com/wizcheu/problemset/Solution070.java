package com.wizcheu.problemset;

/**
 * @author wizcheu
 * @date 2018/07/18 20:57
 * @see <a href="https://leetcode.com/problems/climbing-stairs/description/">https://leetcode.com/problems/climbing-stairs/description/</a>
 */
public class Solution070 {

    // Your solution here
    public int climbStairs(int n) {
        int prev = 0, cur = 1;
        for (int i = 1; i <= n; i++) {
            int temp = cur;
            cur += prev;
            prev = temp;
        }
        return cur;
    }

    public static void main(String[] args) {
        Solution070 st = new Solution070();
        System.out.println(st.climbStairs(3));
    }
}