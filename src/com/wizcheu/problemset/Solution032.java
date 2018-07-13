package com.wizcheu.problemset;

import java.util.*;

/**
 * @author wizcheu
 * @date 2018/07/11 10:58
 * @see <a href="https://leetcode.com/problems/longest-valid-parentheses/description/">https://leetcode.com/problems/longest-valid-parentheses/description/</a>
 */
public class Solution032 {

    // Your solution here...
    public int longestValidParentheses(String s) {
        int max = 0, totalLength = s.length();
        // <position, character>
        Stack<Element> origin = new Stack<>(), tempStack = new Stack<>();
        Map<Integer, Boolean> validMap = new HashMap<>();
        Element element;
        for (char c : s.toCharArray()) {
            element = new Element(--totalLength, c);
            origin.push(element);
            validMap.put(totalLength, false);
        }
        while (!origin.empty()) {
            Element mid = origin.pop();
            if (!tempStack.empty()) {
                Element right = tempStack.peek();
                if ("()".equals(String.valueOf(mid.ch) + String.valueOf(right.ch))) {
                    validMap.put(mid.position, true);
                    validMap.put(right.position, true);
                    tempStack.pop();
                    continue;
                }
            }
            if (!origin.empty()) {
                Element left = origin.peek();
                if ("()".equals(String.valueOf(left.ch) + String.valueOf(mid.ch))) {
                    // check and remove
                    validMap.put(left.position, true);
                    validMap.put(mid.position, true);
                    origin.pop();
                } else {
                    tempStack.add(mid);
                }
            } else {
                break;
            }
        }
        int tempMax = 0;
        for (Integer index : validMap.keySet()) {
            if (validMap.get(index)) {
                tempMax++;
                if (tempMax > max) {
                    max = tempMax;
                }
            } else {
                tempMax = 0;
            }
        }
        return max;
    }

    class Element {
        public int position;
        public char ch;

        public Element(int position, char ch) {
            this.position = position;
            this.ch = ch;
        }

        @Override
        public String toString() {
            return String.valueOf(position) + '-' + String.valueOf(ch);
        }
    }

    public static void main(String[] args) {
        Solution032 st = new Solution032();
        System.out.println(st.longestValidParentheses(")()(())()()("));
    }
}
