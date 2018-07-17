package com.wizcheu.problemset;

/**
 * @author wizcheu
 * @date 2018/07/17 17:18
 * @see <a href="https://leetcode.com/problems/group-anagrams/description/">https://leetcode.com/problems/group-anagrams/description/</a>
 */
public class Solution053 {

    // Your solution here
    public int maxSubArray(int[] nums) {
        int max = 0;
        if (null == nums || 0 == nums.length) {
            return max;
        }
        max = nums[0];
        int sum = max;
        for (int i = 1; i < nums.length; i++) {
            if (sum > 0) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            if (max < sum) {
                max = sum;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution053 st = new Solution053();
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(st.maxSubArray(nums));
    }
}