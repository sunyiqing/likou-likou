package com.li.kou.stack;

/**
 * 接雨水
 *
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。



 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。

 示例:

 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 输出: 6

 * Created by yiqing on 2020/9/1.
 */
public class TrappingRainWate {


    public static void main(String[] args) {
//        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
//       int[] height = {4,2,1,3};
        int[] height = {4,2,4};
        TrappingRainWate wate = new TrappingRainWate();
        System.out.println(wate.trap1(height));
        System.out.println(wate.trap2(height));
    }

    /**
     * 暴力破解
     * 左边取最大，右边取最大
     * 两个最大取最小 - 当前的值，就是能接多少水
     * @param height
     * @return
     */
    public int trap1(int[] height){
        int result = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int left = 0; int right = 0;
            for (int j = 0; j <= i; j++) {
                left = Math.max(height[j],left);
            }
            for (int j = i; j < height.length; j++) {
                right = Math.max(height[j],right);
            }
            result += Math.min(left,right) - height[i];
        }
        return result;
    }


    /**
     * 动态规划
     * dp 的二维数组每一列的最小值 - 当前值 就是能承载的雨水
     * @param height
     * @return
     */
    public int trap2(int[] height){
        if (height.length < 3){
            return 0;
        }
        int result = 0;
        int n = height.length;
        int[][] dp = new int[n][2];


        //第一排，第一个数字
        dp[0][0] = height[0];
        //第二排，最后一个数字放最后一个数字
        dp[n-1][1] = height[n - 1];
        //左第二个数字到右 取最大
        for (int i = 1; i <= n - 1; i++) {
            dp[i][0] = Math.max(height[i],dp[i-1][0]);
        }
        //从右边倒数第二个到左边取最大
        for (int i = n -2; i >= 0; i--) {
            dp[i][1] = Math.max(height[i],dp[i + 1][1]);

        }

        for (int i = 1; i < n - 1; i++) {
            result += Math.min(dp[i][0], dp[i][1]) - height[i];
        }
        return result;

    }
}
