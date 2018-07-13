package com.wizcheu.problemset;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author wizcheu
 * @date 2018/07/08 19:08
 * @see <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters/description/">https://leetcode.com/problems/longest-substring-without-repeating-characters/description/</a>
 */
public class Solution003 {

    // Your solution here...
    public int lengthOfLongestSubstring(String s) {
        if (null == s || s.isEmpty()) {
            return 0;
        }
        int max = 1;
        Map<Character, Integer> map = new HashMap<>();
        int index = 0;
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, index);
            } else {
                map = getCroppedMap(map, map.get(c));
                map.put(c, index);
            }
            if (max < map.size()) {
                max = map.size();
            }
            index++;
        }
        return max;
    }

    public Map<Character, Integer> getCroppedMap(Map<Character, Integer> map, int targetValue) {
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            if (targetValue > map.get((char) it.next())) {
                it.remove();
            }
        }
        return map;
    }

    public static void main(String[] args) {
        Solution003 st = new Solution003();
        System.out.println(st.lengthOfLongestSubstring("ckilbkd"));
    }
}
