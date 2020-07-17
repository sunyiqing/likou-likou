package com.li.kou;


import java.util.HashMap;
import java.util.Map;

public class TheSumOfTwoNums {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int target = 3;
        int[] ints = soulution(nums, target);
        int[] ints1 = soulution1(nums, target);
        int[] ints2 = soulution2(nums, target);
        System.out.println(1);

    }

    public static int[] soulution(int[] nums,int target){
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++){
                if (nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    public static int[] soulution1(int[] nums,int target){
        Map<Integer,Integer> numMap = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            numMap.put(nums[i],i);
        }
        for (int i = 0; i < nums.length; i++) {
            int currentInt = target - nums[i];
            if (numMap.containsKey(currentInt) && numMap.get(currentInt) != i){
                return new int[]{i,numMap.get(currentInt)};
            }
        }
        return null;
    }

    public static int[] soulution2(int[] nums,int target){
        Map<Integer,Integer> numMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (numMap.containsKey(target - nums[i])) {
                return new int[]{i,numMap.get(target - nums[i])};
            }
            numMap.put(nums[i],i);
        }
        return null;
    }


}
