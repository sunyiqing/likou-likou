package com.li.kou.list;

/**
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

  

 示例:

 给定 nums = [2, 7, 11, 15], target = 9

 因为 nums[0] + nums[1] = 2 + 7 = 9
 所以返回 [0, 1]

 * Created by yiqing on 2020/7/18.
 */
public class AddTwoNumbers {


    public static void main(String[] args) {
        ListNode result = new ListNode(0);
        ListNode curr = result;
        for (int i = 0; i < 3; i++) {
            curr.next = new ListNode(i);
            curr = curr.next;
        }

        System.out.println("以上可以了解一下这种结构");


        ListNode l1 = new ListNode(2);
        ListNode l11 = new ListNode(4);
        ListNode l12 = new ListNode(3);
        l1.next = l11;
        l11.next = l12;
        ListNode l2 = new ListNode(5);
        ListNode l21 = new ListNode(6);
        ListNode l22 = new ListNode(4);
        l2.next = l21;
        l21.next = l22;

        ListNode soulution = soulution(l1, l2);
        System.out.print(1);
    }


    private static ListNode soulution(ListNode l1, ListNode l2){
        //返回值
        ListNode result = new ListNode(0);

        ListNode
                p = l1,
                q = l2,
                curr = result;

        //进位值
        int carry = 0;

        while (p != null || q != null){
            //用于记录当前节点的值
            int pVal = p == null ? 0 : p.val;
            int qVal = q == null ? 0 : q.val;

            //计算当前两个节点 + 进位值 一共多少
            int sum = carry + qVal + pVal;

            //求出当前节点的进位值
            carry = sum / 10;

            //将链表下一值 赋值 为 合的个位
            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            if (p != null) p = p.next;
            if (q != null) q = q.next;

            //防止进位后不循环，所以把进位值放到链表最后
            if (carry > 0){
                curr.next = new ListNode(carry);
            }
        }

        return result.next;
    }


    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
