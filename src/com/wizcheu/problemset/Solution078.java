package com.wizcheu.problemset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wizcheu
 * @date 2018/07/20 14:52
 * @see <a href="https://leetcode.com/problems/subsets/description/">https://leetcode.com/problems/subsets/description/</a>
 */
public class Solution078 {

    // Your solution here
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (null == nums || 0 == nums.length) {
            return results;
        }
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<>(), results);
        print(results);
        return results;
    }

    private void dfs(int[] nums, int index, List<Integer> subset, List<List<Integer>> results) {
        if (index == nums.length) {
            results.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[index]);
        dfs(nums, index + 1, subset, results);

        subset.remove(subset.size() - 1);
        dfs(nums, index + 1, subset, results);
    }

    private void print(List<List<Integer>> list) {
        for (List<Integer> l : list) {
            for (int i : l) {
                System.out.print(i + ", ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Solution078 st = new Solution078();
        int[] nums = new int[]{1, 2, 3};
        st.subsets(nums);
    }
}