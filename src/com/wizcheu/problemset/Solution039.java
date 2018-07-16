package com.wizcheu.problemset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wizcheu
 * @date 2018/07/13 20:27
 * @see <a href="https://leetcode.com/problems/combination-sum/description/">https://leetcode.com/problems/combination-sum/description/</a>
 */
public class Solution039 {

    // Your solution here
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (null == candidates || 0 == candidates.length) {
            return result;
        }
        Arrays.sort(candidates);
        List<Integer> path = new ArrayList<>();
        helper(candidates, target, path, 0, result);
        return result;
    }

    private void helper(int[] candidates, int target, List<Integer> path, int index, List<List<Integer>> result) {
        if (0 == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (; index < candidates.length; index++) {
            if (candidates[index] > target) {
                break;
            }
            if (0 != index && candidates[index] == candidates[index - 1]) {
                continue;
            }
            path.add(candidates[index]);
            helper(candidates, target - candidates[index], path, index, result);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution039 st = new Solution039();
        int[] nums = new int[]{2, 3, 5};
        System.out.println(st.combinationSum(nums, 8));
    }
}