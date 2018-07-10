package com.wizcheu.problemset.common;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        ListNode temp = this;
        StringBuilder str = new StringBuilder();
        while (temp != null) {
            str.append(temp.val).append(" -> ");
            temp = temp.next;
        }
        str.append("NULL");
        return str.toString();
    }
}
