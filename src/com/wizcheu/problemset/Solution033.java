package com.wizcheu.problemset;

/**
 * @author wizcheu
 * @date 2018/07/13 09:50
 * @see <a href="https://leetcode.com/problems/search-in-rotated-sorted-array/description/">https://leetcode.com/problems/search-in-rotated-sorted-array/description/</a>
 */
public class Solution033 {

    // Your solution here
    public int search(int[] nums, int target) {
        if (null == nums || 0 == nums.length) {
            return -1;
        }
        int left = 0, right = nums.length - 1, mid;
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            if (nums[left] < nums[mid]) {
                if (nums[left] <= target && target <= nums[mid]) {
                    right = mid;
                } else {
                    left = mid;
                }
            } else {
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
        }
        if (target == nums[left]) {
            return left;
        }
        if (target == nums[right]) {
            return right;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution033 st = new Solution033();
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        System.out.println(st.search(nums, 1));
    }
}