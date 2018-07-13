package com.wizcheu.problemset;


import com.wizcheu.problemset.common.ListNode;

/**
 * @author wizcheu
 * @date 2018/07/08 15:16
 * @see <a href="https://leetcode.com/problems/add-two-numbers/description/">https://leetcode.com/problems/add-two-numbers/description/</a>
 */
public class Solution002 {

    // Your solution here...
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tempNode = new ListNode(0), tailNode = tempNode;
        int decimal = 0;
        while (null != l1 || null != l2) {
            int sum = decimal;
            sum += (null != l1) ? l1.val : 0;
            sum += (null != l2) ? l2.val : 0;
            tailNode.next = new ListNode(sum % 10);
            tailNode = tailNode.next;
            decimal = sum / 10;
            l1 = (null != l1) ? l1.next : null;
            l2 = (null != l2) ? l2.next : null;
        }
        if (decimal != 0) {
            tailNode.next = new ListNode(decimal);
        }

        return tempNode.next;
    }


    public static void main(String[] args) {
        Solution002 st = new Solution002();
        ListNode l11 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(3);
        l11.next = l12;
        l12.next = l13;

        ListNode l21 = new ListNode(5);
        ListNode l22 = new ListNode(6);
        ListNode l23 = new ListNode(4);
        l21.next = l22;
        l22.next = l23;

        System.out.println(st.addTwoNumbers(l11, l21).toString());
    }
}