package com.wizcheu.problemset;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wizcheu
 * @date 2018/07/08 15:14
 * @see <a href="https://leetcode.com/problems/two-sum/">https://leetcode.com/problems/two-sum/</a>
 */
public class Solution001 {

    // Your solution here...
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (null != map.get(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        Solution001 st = new Solution001();
        int[] result = st.twoSum(nums, 6);
        System.out.println(Arrays.toString(result));
    }
}
