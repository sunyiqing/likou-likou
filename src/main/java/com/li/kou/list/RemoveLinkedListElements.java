package com.li.kou.list;

import com.li.kou.common.ListNode;

/**
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
public class RemoveLinkedListElements {


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l11 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(5);
        ListNode l14 = new ListNode(6);
        l1.next = l11;
        l11.next = l12;
        l12.next = l13;
        l13.next = l14;
        removeElements(l1,1);
    }


    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null){
            if (curr.val == val){
                prev.next = curr.next;
            }else {
                prev = curr;
            }
            curr = curr.next;
        }

        return dummy.next;
    }

}
