package com.wizcheu.problemset;

import java.util.*;

/**
 * @author wizcheu
 * @date 2018/07/09 19:46
 * @see <a href="https://leetcode.com/problems/3sum/description/">https://leetcode.com/problems/3sum/description/</a>
 */
public class Solution015 {

    // Your solution here...
    public List<List<Integer>> threeSum(int[] nums) {
        // sort the nums
        Arrays.sort(nums);
        int totalLength = nums.length;
        List<List<Integer>> resultList = new ArrayList<>();
        for (int left = 0; left < totalLength; left++) {
            int mid = left + 1, right = totalLength - 1;
            if (left > 0 && nums[left] == nums[left - 1]) {
                continue;
            }
            System.out.println(left + ";" + mid + ";" + right);
            while (mid < right) {
                int missingValue = -nums[left];
                if (missingValue == nums[mid] + nums[right]) {
                    int tempMid = nums[mid], tempRight = nums[right];
                    resultList.add(Arrays.asList(nums[left], nums[mid], nums[right]));
                    while (mid < right && nums[++mid] == tempMid) ;
                    while (mid < right && nums[--right] == tempRight) ;
                } else if (missingValue > nums[mid] + nums[right]) {
                    mid++;
                } else {
                    right--;
                }
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        Solution015 st = new Solution015();
        int[] nums = new int[]{-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6};
        System.out.println(st.threeSum(nums).toString());
    }
}
