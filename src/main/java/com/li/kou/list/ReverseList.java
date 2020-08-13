package com.li.kou.list;

/**
 * 单链表反转
 * https://www.cnblogs.com/keeya/p/9218352.html
 */

import com.li.kou.common.ListNode;

public class ReverseList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l11 = new ListNode(4);
        ListNode l12 = new ListNode(3);
        l1.next = l11;
        l11.next = l12;
//        ListNode listNode = reverseList1(l1);
        ListNode listNode1 = reverseList2(l1);
        System.out.println(1);

    }


    /**
     * TODO:没有看懂
     * @param head
     * @return
     */
    private static ListNode reverseList2(ListNode head){
        if (head == null || head.next == null)
            return head;

        ListNode temp = head.next;

        ListNode newHead = reverseList2(head.next);
        temp.next = head;
        head.next = null;
        return newHead;
    }
    /**
     * 0、2——>4——>3
     * 1、4——>3   2——>null
     * 2、3       4——>2——>null
     * 3、null    3——>4——>2——>null
     * @param listNode
     * @return
     */
    private static ListNode reverseList1(ListNode listNode){
        ListNode preListNode = null;
        ListNode nextListNode = null;

        while (listNode != null){
            nextListNode = listNode.next;
            listNode.next = preListNode;
            preListNode = listNode;
            listNode = nextListNode;
        }
        return preListNode;

    }
}
