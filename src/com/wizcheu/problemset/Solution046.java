package com.wizcheu.problemset;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wizcheu
 * @date 2018/07/16 16:59
 * @see <a href="https://leetcode.com/problems/permutations/description/">https://leetcode.com/problems/permutations/description/</a>
 */
public class Solution046 {

    // Your solution here
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (null == nums || 0 == nums.length) {
            return result;
        }
        List<Integer> list = new ArrayList<>();
        permutation(nums, result, list);
        return result;
    }

    private void permutation(int[] nums, List<List<Integer>> result, List<Integer> list) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!list.contains(nums[i])) {
                    List<Integer> tempList = new ArrayList<>(list);
                    tempList.add(nums[i]);
                    permutation(nums, result, tempList);
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution046 st = new Solution046();
        int[] nums = new int[]{1, 2, 3};
        System.out.println(st.permute(nums));
    }
}