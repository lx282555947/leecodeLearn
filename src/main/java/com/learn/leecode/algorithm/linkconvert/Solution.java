package com.learn.leecode.algorithm.linkconvert;

import com.learn.leecode.datastructure.ListNode;
import com.learn.leecode.utils.PrintUtil;

public class Solution {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
//        ListNode listNode = reverseList1(node1);
        ListNode listNode = reverseList2(node1);
        PrintUtil.printLinkList(listNode);
    }

    /**
     * 保存前一个节点
     */
    public static ListNode reverseList1(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        ListNode temp = null;
        while (curr!= null) {
            //将下一个节点临时存储
            temp = curr.next;
            //将next更改为pre

            curr.next = pre;
            //将当前节点赋值给pre
            pre = curr;
            curr = temp;
        }
        return pre;
    }

    /**
     * 递归
     */
    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //1->2->3->4->5
        ListNode listNode = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return listNode;
    }
}
