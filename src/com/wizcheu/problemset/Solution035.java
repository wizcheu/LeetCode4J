package com.wizcheu.problemset;

/**
 * @author wizcheu
 * @date 2018/07/13 19:23
 * @see <a href="https://leetcode.com/problems/search-insert-position/description/">https://leetcode.com/problems/search-insert-position/description/</a>
 */
public class Solution035 {

    // Your solution here
    public int searchInsert(int[] nums, int target) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        if (target < nums[0]) {
            return 0;
        } else if (target > nums[nums.length - 1]) {
            return nums.length;
        }
        int left = 0, right = nums.length - 1, mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (left == mid) {
                if (nums[left] == target) {
                    return left;
                }
                return left + 1;
            }
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Solution035 st = new Solution035();
        int[] nums = new int[]{1, 3};
        System.out.println(st.searchInsert(nums, 1));
    }
}