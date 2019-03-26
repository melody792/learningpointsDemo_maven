/* ****************************************************************** */
/*                                                                    */
/* IBM Confidential                                                   */
/*                                                                    */
/* OCO Source Materials                                               */
/* 5900-A1H                                                           */
/* © Copyright IBM Corp. 2019                                         */
/*                                                                    */
/* The source code for this program is not published or otherwise     */
/* divested of its trade secrets, irrespective of what has been       */
/* deposited with the U.S. Copyright Office.                          */
/*                                                                    */
/* ****************************************************************** */
package com.pzb.demo;

/**
 * create by pzhbao on 14/03/2019
 *
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class LinkListSolution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int carry = 0;
        while(l1 != null || l2 != null) {
            int d1 = l1==null ? 0 : l1.val;
            int d2 = l2==null ? 0 : l2.val;
            int sum = d1 + d2 + carry;
            carry = sum >= 10 ? 1 : 0; //进位下次循环用
            cur.next = new ListNode(sum % 10); //显示个位数
            cur = cur.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return null;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
