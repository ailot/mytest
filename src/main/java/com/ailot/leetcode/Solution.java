package com.ailot.leetcode;

public class Solution {


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(8);

        ListNode l2 = new ListNode(0);
        addTwoNumbers(l1, l2);
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p = l1, q = l2, current = head;
        int carry = 0;
        while (p != null && q != null) {
            int x = (p!=null) ? p.val : 0;
            int y = (q!=null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum/10;
            current.next = new ListNode(sum%10);
            current = current.next;
            if (p != null){
                p = p.next;
            }
            if (q != null){
                q = q.next;
            }
        }
        if (carry > 0){
            current.next = new ListNode(carry);
        }
        return head.next;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
