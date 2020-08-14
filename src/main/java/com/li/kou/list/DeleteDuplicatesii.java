package com.li.kou.list;

import com.li.kou.common.ListNode;

public class DeleteDuplicatesii {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l12 = new ListNode(1);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(4);
        ListNode l6 = new ListNode(5);
        ListNode l7 = new ListNode(5);
        ListNode l8 = new ListNode(5);
        l1.next = l2;
        l2.next = l12;
        l12.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = l8;
        deleteDuplicates(l1);
    }

    /**
     * TODO:
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;  // 若head为空则直接返回null
        ListNode dummy = new ListNode(-1);  // 建立一个虚拟头结点
        ListNode tail = dummy;  // 定义一个尾巴，用于尾插法。
        for (ListNode l = head, r = head; l != null; l = r) {
            while (r != null && r.val == l.val) r = r.next;  // 只要r不为空并且与l的值相等则一直向后移动
            if (l.next == r) {  // 若长度为1，则通过尾插法加入。
                tail.next = l;  // 基本的尾插法
                tail = l;
                tail.next = null;  // 这里记得将尾部的后面置为null，不然可能后面会带着一些其他的节点。
            }
        }
        return dummy.next;
    }
}
