package com.li.kou.list;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 *
 */
public class RemoveNthNodeFromEndOfList {

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
        RemoveNthNodeFromEndOfList removeNthNodeFromEndOfList = new RemoveNthNodeFromEndOfList();

        removeNthNodeFromEndOfList.removeNthFromEnd1(l1,5);


    }

    /**
     * dummy 存在的意义就是当n = 倒数最大那个数的时候要保证不空指针，并且能移除第一位
     *
     * 举例 n = 4 , 2 要被踢出
     * 经历一轮循环
     * first 是 6
     * second 是 0 1 2 4 5 6
     *
     * 经理第二次循环
     * first 是 null
     * second 是  1 2 3 4 5 6
     *
     * 得到 1 3 4 5 6
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;  //删除某个元素
        return dummy.next;
    }



    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
