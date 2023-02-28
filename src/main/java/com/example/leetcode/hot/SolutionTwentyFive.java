package com.example.leetcode.hot;

/**
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个下标
 */
public class SolutionTwentyFive {
    //递归，每一个模块自己最远可以跳多少

    public boolean canJump(int[] nums) {
        if(nums==null) return false;
        int  k=0;
        for (int i=0;i<=k;i++){
            int temp=i+nums[i];
            k=Math.max(k,temp);
            if(k>=nums.length-1){
                return true;
            }
        }
        return false;
    }
    //贪心算法 每次都跳得最远 遍历过程中维护最远可以到达的位置
    public boolean canJump1(int[] nums){
        int n=nums.length;
        int rightmax=0;
        for(int i=0;i<n;i++){
            if(i<=rightmax){
                Math.max(rightmax,nums[i]+1);
            }
            if (rightmax>=n-1) return true;
        }
        return false;
    }
}
