package com.li.kou.list;

import com.li.kou.common.ListNode;

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 *
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 *
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 *
 */
public class DeleteDuplicates {


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        deleteDuplicates(l1);
        System.out.println(1);
    }
    private static ListNode deleteDuplicates(ListNode listNode){
        ListNode currNode = listNode;

        while (currNode != null && currNode.next != null){
            if (currNode.val == currNode.next.val){
                currNode.next = currNode.next.next;
            }else {
                currNode = currNode.next;
            }
        }
        return listNode;
    }
}
