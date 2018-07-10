package com.wizcheu.problemset;

import com.wizcheu.problemset.common.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wizcheu
 * @date 2018/07/10 20:19
 * @see <a href="https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/">https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/</a>
 */
public class Solution019 {

    // Your solution here...
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int total = 0;
        Map<Integer, ListNode> nodeMap = new HashMap<>();
        ListNode temp = head;
        while (null != temp) {
            nodeMap.put(++total, temp);
            temp = temp.next;
        }
        if (0 == total - n) {
            return head.next;
        }
        nodeMap.get(total - n).next = nodeMap.get(total - n + 2);
        return head;
    }


    public static void main(String[] args) {
        Solution019 st = new Solution019();
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ListNode ln3 = new ListNode(3);
        ListNode ln4 = new ListNode(4);
        ListNode ln5 = new ListNode(5);
//        ln1.next = ln2;
//        ln2.next = ln3;
//        ln3.next = ln4;
//        ln4.next = ln5;
        System.out.println(st.removeNthFromEnd(ln1, 1).toString());
    }
}