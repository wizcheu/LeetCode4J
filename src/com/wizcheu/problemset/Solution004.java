package com.wizcheu.problemset;

/**
 * @author wizcheu
 * @date 2018/07/08 19:55
 * @see <a href="https://leetcode.com/problems/median-of-two-sorted-arrays/description/">https://leetcode.com/problems/median-of-two-sorted-arrays/description/</a>
 */
public class Solution004 {

    // Your solution here...
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        if (0 == totalLength % 2) {
            return (findKth(nums1, 0, nums2, 0, totalLength / 2) +
                    findKth(nums1, 0, nums2, 0, totalLength / 2 + 1)) / 2.0;
        }
        return findKth(nums1, 0, nums2, 0, totalLength / 2 + 1);
    }

    public double findKth(int[] nums1, int a, int[] nums2, int b, int k) {
        if (a >= nums1.length) {
            return nums2[b + k - 1];
        }
        if (b >= nums2.length) {
            return nums1[a + k - 1];
        }
        if (1 == k) {
            return Math.min(nums1[a], nums2[b]);
        }
        int halfKthOfNums1 = a + k / 2 - 1 < nums1.length ? nums1[a + k / 2 - 1] : Integer.MAX_VALUE;
        int halfKthOfNums2 = b + k / 2 - 1 < nums2.length ? nums2[b + k / 2 - 1] : Integer.MAX_VALUE;
        if (halfKthOfNums1 < halfKthOfNums2) {
            return findKth(nums1, a + k / 2, nums2, b, k - k / 2);
        } else {
            return findKth(nums1, a, nums2, b + k / 2, k - k / 2);
        }

    }

    public static void main(String[] args) {
        Solution004 st = new Solution004();
        int[] nums1 = new int[]{6, 9, 18};
        int[] nums2 = new int[]{11};
        System.out.println(st.findMedianSortedArrays(nums1, nums2));
    }
}
