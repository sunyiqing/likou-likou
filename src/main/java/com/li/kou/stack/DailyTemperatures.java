package com.li.kou.stack;

import com.alibaba.fastjson.JSON;

import java.util.Deque;
import java.util.LinkedList;

/**
 *
 * 739. 每日温度
 * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 *
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/daily-temperatures
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DailyTemperatures {


    public static void main(String[] args) {
        int[] temperatures = {73, 72, 71, 76, 69, 72, 76, 73};
//        int[] temperatures = {73};
        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        int[] ints = dailyTemperatures.dailyTemperatures(temperatures);
        int[] ints1 = dailyTemperatures.dailyTemperatures1(temperatures);
        System.out.println(1);


    }

    /**
     * 暴力破解
     * @param T
     * @return
     */
    public int[] dailyTemperatures(int[] T){
        int len  = T.length;
        if (len < 2){
            return new int[len];
        }
        int[] res = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            for (int j = i + 1; j < T.length; j++){
                if (T[i] < T[j]){
                    res[i] = j - i;
                    break;
                }
            }
        }

        return res;
    }

    /**
     * 单调栈 从左到右边，只要当前数据 大于栈顶数据就出栈
     * 0
     * 0 1
     * 0 1 2
     * 3
     * 3 4
     * 3 5
     * 3 6
     * 3 6 7
     *
     * @param T
     * @return
     */
    public int[] dailyTemperatures1(int[] T){
        int len = T.length;
        int[] res = new int[len];
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]){
                stack.pop();
            }

        }
        return res;
    }



}
