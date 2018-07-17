package com.wizcheu.problemset;

import java.util.*;

/**
 * @author wizcheu
 * @date 2018/07/17 16:46
 * @see <a href="https://leetcode.com/problems/group-anagrams/description/">https://leetcode.com/problems/group-anagrams/description/</a>
 */
public class Solution049 {

    // Your solution here
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (null == strs || 0 == strs.length) {
            return result;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = Arrays.toString(chars);
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }
        }
        Iterator iterator = map.values().iterator();
        while (iterator.hasNext()) {
            result.add((List<String>) iterator.next());
        }
        return result;
    }

    public static void main(String[] args) {
        Solution049 st = new Solution049();
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(st.groupAnagrams(strs));
    }
}