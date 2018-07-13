package com.wizcheu.problemset;

import com.wizcheu.problemset.common.ListNode;


/**
 * @author wizcheu
 * @date 2018/07/11 08:33
 * @see <a href="https://leetcode.com/problems/merge-two-sorted-lists/description/">https://leetcode.com/problems/merge-two-sorted-lists/description/</a>
 */
public class Solution021 {

    // Your solution here...
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode tempNode = new ListNode(0), sortedListNode = tempNode;
        while (null != l1 && null != l2) {
            if (l1.val < l2.val) {
                sortedListNode.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                sortedListNode.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            sortedListNode = sortedListNode.next;
        }
        if (null != l1) {
            sortedListNode.next = l1;
        }
        if (null != l2) {
            sortedListNode.next = l2;
        }
        return tempNode.next;
    }

    public static void main(String[] args) {
        ListNode ln11 = new ListNode(0);
        ListNode ln12 = new ListNode(1);
        ListNode ln13 = new ListNode(2);
        ln11.next = ln12;
        ln12.next = ln13;
        ListNode ln21 = new ListNode(1);
        ListNode ln22 = new ListNode(3);
        ListNode ln23 = new ListNode(4);
        ln21.next = ln22;
        ln22.next = ln23;
        Solution021 st = new Solution021();
        System.out.println(st.mergeTwoLists(ln11, ln21));
    }
}
