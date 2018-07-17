package com.wizcheu.problemset;

/**
 * @author wizcheu
 * @date 2018/07/17 19:53
 * @see <a href="https://leetcode.com/problems/jump-game/description/">https://leetcode.com/problems/jump-game/description/</a>
 */
public class Solution055 {

    // Your solution here
    public boolean canJump(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return false;
        }
        int totalLength = nums.length;
        if (1 == totalLength) {
            if (0 <= nums[0]) {
                return true;
            } else {
                return false;
            }
        }
        boolean[] can = new boolean[totalLength];
        for (int i = totalLength - 2; i >= 0; i--) {
            if (nums[i] >= totalLength - i - 1) {
                can[i] = true;
            } else {
                can[i] = false;
            }
            if (!can[i]) {
                for (int j = i; j < totalLength - 1 && j <= i + nums[i]; j++) {
                    if (can[j]) {
                        can[i] = true;
                    }
                }
            }
        }
//        printBooleanArray(can);
        return can[0];
    }

    private void printBooleanArray(boolean[] b) {
        for (boolean b1 : b) {
            System.out.print(b1 + " ");
        }
    }

    public static void main(String[] args) {
        Solution055 st = new Solution055();
        int[] nums = new int[]{2, 3, 0, 1, 4};
        System.out.println(st.canJump(nums));
    }
}