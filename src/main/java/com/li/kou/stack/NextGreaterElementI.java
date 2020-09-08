package com.li.kou.stack;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class NextGreaterElementI {
    public static void main(String[] args) {
        int[] nums1 = {4,1,2};
        int[] nums2 = {2,3,4,7,1,5};
//        [-1,3,-1]
        NextGreaterElementI nextGreaterElement = new NextGreaterElementI();
        for (int i : nextGreaterElement.s1(nums1, nums2)) {
            System.out.println(i);
        }
        System.out.println("-----------");
        for (int i : nextGreaterElement.s2(nums1, nums2)) {
            System.out.println(i);
        }
    }

    public int[] s1(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int cur = nums1[i];
            for (int i1 = 0; i1 < nums2.length; i1++) {
                if (cur == nums2[i1]){
                    for (int i2 = i1; i2 < nums2.length; i2++) {
                        if (cur < nums2[i2]){
                            res[i] = nums2[i2];
                            break;
                        }
                        if (i2 == nums2.length - 1){
                            res[i] = -1;
                            break;
                        }
                    }
                }
            }
        }
        return res;
    }
    public int[] s2(int[] nums1, int[] nums2){
        int[] res = new int[nums1.length];

        Deque<Integer> stack = new LinkedList<Integer>();
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]){
                map.put(nums2[stack.pop()],nums2[i]);
            }
            stack.push(i);
        }
        for (int i = 0; i < nums1.length; i++) {
            if (map.get(nums1[i]) == null) {
                res[i] = -1;
                continue;
            }
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}
