package com.example.leetcode.hot;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组 是数组中的一个连续部分。
 * 动态规划
 * ①理解题意
 *最大的 连续 子序列
 * ②定义子问题
 * 无后效性：子问题定义时存在不确定的地方
 */
public class SolutionTwentyFour {
    /**
     * 子问题定义
     * 以 * 为结尾的连续子数组最大和是多少
     * 如果编号i的子问题结果是负数或者0，那么编号i+1的子问题就可以把编号为i的子问题舍掉
     * dp[i]:表示以nums[i]结尾的连续子数组的最大和
     * 状态转移方程：描述子问题之间的联系
     */
    public int maxSubArray(int[] nums){
        int length= nums.length;
        int[] dp=new int[length];
        dp[0]=nums[0];
        for(int i=1;i<length;i++){
            if(dp[i-1]>0) dp[i]=dp[i-1]+nums[i];
            else dp[i]=nums[i];
        }
        int result=dp[0];
        for(int i=0;i<length;++i){
            result=Math.max(result,dp[i]);
        }
        return result;
    }
    public int[] twoSum(int[] nums, int target){
        Map<Integer,Integer> hashMap=new HashMap<Integer,Integer>();
        for (int i=0;i<nums.length;i++){
            if(hashMap.containsKey(target-nums[i]))
                return new int[] {hashMap.get(target-nums[i]),i};
            else{
                hashMap.put(nums[i],i);
            }

        }
        return new int[0];
    }

}
