package com.wizcheu.problemset;

/**
 * @author wizcheu
 * @date 2018/07/13 12:42
 * @see <a href="https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/">https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/</a>
 */
public class Solution034 {

    // Your solution here
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        int left = 0, right = nums.length;
        result[0] = findLeft(nums, left, right, target);
        result[1] = findRight(nums, left, right, target) - 1;
        if (result[0] > result[1]) {
            result[0] = result[1] = -1;
        }
        return result;
    }

    private int findLeft(int[] nums, int left, int right, int target) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private int findRight(int[] nums, int left, int right, int target) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Solution034 st = new Solution034();
        int[] nums = new int[]{2, 2};
        int[] result = st.searchRange(nums, 2);
        System.out.println(result[0] + " : " + result[1]);
    }
}