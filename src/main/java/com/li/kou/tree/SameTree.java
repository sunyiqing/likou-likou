package com.li.kou.tree;

import com.li.kou.common.TreeNode;

/**
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * 示例 1:
 *
 * 输入:       1         1
 *           / \       / \
 *          2   3     2   3
 *
 *         [1,2,3],   [1,2,3]
 *
 * 输出: true
 * 示例 2:
 *
 * 输入:      1          1
 *           /           \
 *          2             2
 *
 *         [1,2],     [1,null,2]
 *
 * 输出: false
 * 示例 3:
 *
 * 输入:       1         1
 *           / \       / \
 *          2   1     1   2
 *
 *         [1,2,1],   [1,1,2]
 *
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/same-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SameTree {


    public static void main(String[] args) {

        TreeNode p = new TreeNode(1,new TreeNode(2,new TreeNode(6),new TreeNode(9)),new TreeNode(3));
        TreeNode q = new TreeNode(1,new TreeNode(2,new TreeNode(6),new TreeNode(9)),new TreeNode(4));

        boolean sameTree = isSameTree(p, q);
        System.out.println(sameTree);
    }


    public static boolean isSameTree(TreeNode p, TreeNode q) {
        System.out.println("===================");
        if (p != null){
            System.out.println("p:" + p.val);
        }else {
            System.out.println("p:null");

        }
        if (q != null){
            System.out.println("q:" + q.val);
        }else {
            System.out.println("q:null");
        }


        if (p ==null && q == null){
            return true;
        }else if (p == null || q == null){
            return false;
        }else if (p.val != q.val){
            return false;
        }else {
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }
    }
}
