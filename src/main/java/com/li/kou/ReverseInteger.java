package com.li.kou;

/**
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


    protected static int soulution1(int num){
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
