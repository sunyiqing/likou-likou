package com.li.kou;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

 示例 1:

 输入: 123
 输出: 321
  示例 2:

 输入: -123
 输出: -321
 示例 3:

 输入: 120
 输出: 21
 注意:

 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。

 * Created by yiqing on 2020/7/18.
 */
public class ReverseInteger {


    public static void main(String[] args) {

        int s1 = soulution(123);
        System.out.print(s1);
        int s2 = soulution(-123);
        System.out.print(s2);
        int s3 = soulution(-120);
        System.out.print(s3);
        int s4 = soulution1(123);
        System.out.print(s4);
        int s5 = soulution1(-120);
        System.out.print(s5);

    }

    private static int soulution(int num){
        long temp = 0;
        while (num != 0){
            temp = temp * 10 + num % 10;
            if (temp > Integer.MAX_VALUE || temp < Integer.MIN_VALUE){
                return 0;
            }
            num = num / 10;
        }
        return (int)temp;
    }

    private static int soulution1(int num){
        int ans = 0;
        while (num != 0){
            if((ans * 10) / 10 != ans){
                ans = 0;
                break;
            }
            ans = ans * 10 + num % 10;
            num = num / 10;
        }
        return ans;
    }


}
