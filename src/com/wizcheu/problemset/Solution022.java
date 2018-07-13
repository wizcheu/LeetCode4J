package com.wizcheu.problemset;

import com.wizcheu.problemset.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wizcheu
 * @date 2018/07/11 09:04
 * @see <a href="https://leetcode.com/problems/generate-parentheses/description/">https://leetcode.com/problems/generate-parentheses/description/</a>
 */
public class Solution022 {

    // Your solution here...
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }
        StringBuilder sb = new StringBuilder(n * 2);
        recurse(0, 0, sb, result, n);
        return result;
    }

    public void recurse(int left, int right, StringBuilder sb, List<String> list, int n) {
        if (sb.length() == n * 2) {
            list.add(sb.toString());
            return;
        }

        // add '('
        if (left < n) {
            recurse(left + 1, right, sb.append("("), list, n);
            sb.deleteCharAt(sb.length() - 1);
        }

        // add ')'
        if (right < left) {
            recurse(left, right + 1, sb.append(")"), list, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        Solution022 st = new Solution022();
        System.out.println(st.generateParenthesis(2));
    }
}
