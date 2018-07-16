package com.wizcheu.problemset;

/**
 * @author wizcheu
 * @date 2018/07/16 15:19
 * @see <a href="https://leetcode.com/problems/trapping-rain-water/description/">https://leetcode.com/problems/trapping-rain-water/description/</a>
 */
public class Solution042 {

    // Your solution here
    public int trap(int[] height) {
        if (null == height || 0 == height.length) {
            return 0;
        }
        int left = 0, right = height.length - 1, result = 0;
        int leftHeight = height[left], rightHeight = height[right];
        while (left < right) {
            if (leftHeight < rightHeight) {
                left++;
                if (leftHeight > height[left]) {
                    result += (leftHeight - height[left]);
                } else {
                    leftHeight = height[left];
                }
            } else {
                right--;
                if (rightHeight > height[right]) {
                    result += (rightHeight - height[right]);
                } else {
                    rightHeight = height[right];
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        Solution042 st = new Solution042();
        System.out.println(st.trap(height));
    }
}