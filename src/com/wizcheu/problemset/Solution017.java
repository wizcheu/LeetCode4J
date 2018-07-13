package com.wizcheu.problemset;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wizcheu
 * @date 2018/07/10 09:23
 * @see <a href="https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/">https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/</a>
 */
public class Solution017 {

    // Your solution here...
    public List<String> letterCombinations(String digits) {
        List<String> resultList = new ArrayList<>();
        String[] digitMapper = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        if (!digits.isEmpty()) {
            resultList.add("");
            for (int i = 0; i < digits.length(); i++) {
                resultList =combine(digitMapper[digits.charAt(i) - '0'], resultList);
            }
        }
        return resultList;
    }

    public List<String> combine(String digit, List<String> strings) {
         List<String> result = new ArrayList<>();
         for (int i = 0; i < digit.length(); i++) {
             for (String s : strings) {
                 result.add(s + digit.charAt(i));
             }
         }
         return result;
    }

    public static void main(String[] args) {
        Solution017 st = new Solution017();
        System.out.println(st.letterCombinations("22").toString());
    }
}
