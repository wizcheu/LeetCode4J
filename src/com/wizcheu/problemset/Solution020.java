package com.wizcheu.problemset;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author wizcheu
 * @date 2018/07/10 21:16
 * @see <a href="https://leetcode.com/problems/valid-parentheses/description/">https://leetcode.com/problems/valid-parentheses/description/</a>
 */
public class Solution020 {

    // Your solution here...
    public boolean isValid(String s) {
        if (s.isEmpty()) {
            return true;
        }
        // Stack
        String[] validStrings = new String[]{"()", "{}", "[]"};
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.empty()) {
                if (Arrays.asList(validStrings).contains(String.valueOf(stack.peek()) + String.valueOf(c))) {
                    // remove the peek
                    stack.pop();
                } else {
                    stack.push(c);
                }
            } else {
                stack.push(c);
            }
        }
        return stack.empty();
    }


    public static void main(String[] args) {
        Solution020 st = new Solution020();
        System.out.println(st.isValid("[{}]"));
    }
}
