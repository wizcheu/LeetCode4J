package com.wizcheu.problemset;

/**
 * @author wizcheu
 * @date 2018/07/09 19:17
 * @see <a href="https://leetcode.com/problems/container-with-most-water/discuss/">https://leetcode.com/problems/container-with-most-water/discuss/</a>
 */
public class Solution011 {

    // Your solution here...
    public int maxArea(int[] height) {
        int totalLength = height.length, max = 0;
        for (int i = 0, j = totalLength - 1; i < j; ) {
            int area = (j - i) * Math.min(height[i], height[j]);
            if (max < area) {
                max = area;
            }
            // let the smaller one go to the next cursor
            // to make sure that the area won't be smaller
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }


    public static void main(String[] args) {
        Solution011 st = new Solution011();
        int[] height = new int[]{1, 3, 2, 4, 5, 6};
        System.out.println(st.maxArea(height));
    }
}
