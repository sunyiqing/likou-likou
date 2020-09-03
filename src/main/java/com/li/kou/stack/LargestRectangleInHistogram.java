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
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/bao-li-jie-fa-zhan-by-liweiwei1419/
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LargestRectangleInHistogram {

    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};

        LargestRectangleInHistogram l = new LargestRectangleInHistogram();
        System.out.println(l.largestRectangleArea1(heights));
    }


    /**
     * 暴力破解的方法
     * @param heights
     * @return
     */
    public int largestRectangleArea1(int[] heights) {
        int result = 0;
        if (heights == null || heights.length == 0){
            return result;
        }

        for (int i = 0; i < heights.length; i++) {
            int curHeight = heights[i];

            //从当前元素左边开始 向左边比较，一直到比当前元素要小
            int left = i;
            while (left > 0 && heights[left - 1] >= curHeight){
                left--;
            }

            //从当前元素右边开始，向右比较，一直到比当前元素要小
            int rigth = i;
            while (rigth <  heights.length - 1 && heights[rigth + 1] >= curHeight){
                rigth ++;
            }

            int width = rigth - left + 1;
            result = Math.max(result,width * curHeight);
        }

        return result;
    }
}
