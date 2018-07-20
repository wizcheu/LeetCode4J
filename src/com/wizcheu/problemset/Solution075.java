package com.wizcheu.problemset;

/**
 * @author wizcheu
 * @date 2018/07/19 14:53
 * @see <a href="https://leetcode.com/problems/sort-colors/description/">https://leetcode.com/problems/sort-colors/description/</a>
 */
public class Solution075 {

    // Your solution here
    public void sortColors(int[] nums) {
        if (null == nums || 1 >= nums.length) {
            return;
        }
        int left = 0, right = nums.length - 1, i = 0;
        while (i <= right) {
            if (0 == nums[i]) {
                swap(nums, left, i);
                left++;
                i++;
            } else if (1 == nums[i]) {
                i++;
            } else {
                swap(nums, right, i);
                right--;
            }
        }
        print(nums);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void print(int[] nums) {
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        Solution075 st = new Solution075();
        int[] nums = new int[]{2, 0, 2, 1, 1, 0};
        st.sortColors(nums);
    }
}