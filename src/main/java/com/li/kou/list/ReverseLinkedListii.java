package com.li.kou.list;

import com.li.kou.common.ListNode;

/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。

 说明:
 1 ≤ m ≤ n ≤ 链表长度。

 示例:

 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 输出: 1->4->3->2->5->NULL

 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * Created by yiqing on 2020/8/14.
 */
public class ReverseLinkedListii {

    public static void main(String[] args) {
        ListNode l1 = new  ListNode(1);
        ListNode l11 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(5);
        ListNode l14 = new ListNode(6);
        l1.next = l11;
        l11.next = l12;
        l12.next = l13;
        l13.next = l14;

    }



}
