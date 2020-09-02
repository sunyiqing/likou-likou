package com.li.kou.stack;

/**
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 *  
 *
 *
 *
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 *
 *  
 *
 *
 *
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 *
 *  
 *
 * 示例:
 *
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LargestRectangleInHistogram {

    public static void main(String[] args) {
//        int[] heights = {2,1,5,1,2,3};
        int[] heights = {1};

        LargestRectangleInHistogram l = new LargestRectangleInHistogram();
        System.out.println(l.largestRectangleArea1(heights));
    }
    public int largestRectangleArea1(int[] heights) {
        int result = 0;
        if (heights == null || heights.length <= 0){
            return result;
        }
        if (heights.length == 1){
            return heights[0];
        }

        for (int i = 0; i < heights.length - 1; i++) {
            int min = Math.min(heights[i],heights[i + 1]);
            result = Math.max(result, min);
        }
        return result * 2;
    }
}
