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
        ListNode l12 = new ListNode(1);
        ListNode l13 = new ListNode(1);
        ListNode l14 = new ListNode(1);
        l1.next = l11;
        l11.next = l12;
        l12.next = l13;
        l13.next = l14;
        removeElements(l1,1);
    }


    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        //用于删除节点
        ListNode prev = dummy;
        //用于节点移动
        ListNode curr = head;


        while (curr != null){
            if (curr.val == val){
                //相等 直接指向下一个
                prev.next = curr.next;
            }else {
                //prev 与 curr 一起移动
                prev = curr;
            }
            //curr 移动
            curr = curr.next;
        }
        return dummy.next;
    }

}
