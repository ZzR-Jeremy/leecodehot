package com.example.leetcode.zhouyu;

import java.util.Arrays;

/**
 * 三个数的最大乘积
 * 在数组中找出由三个数组成的最大乘积
 * 全正或者全负都是取其中最大的三个相乘
 * 有正有负则即可能是三个最大的数相乘，也可能是两个绝对值最大的负数的乘积与最大的正数相乘
 */
public class MaxinumProduct {
    public int maxinumProduct1(int[] nums){
        //升序
        Arrays.sort(nums);
        int n=nums.length;
        int ans=Math.max(nums[n-3]*nums[n-2]*nums[n-1],nums[0]*nums[1]*nums[n-1]);
        return ans;
    }
    //线性扫描 降低时间复杂度
    public int maxinumProduct2(int[] nums){
        int min1=Integer.MAX_VALUE,min2=Integer.MAX_VALUE;
        int max1=Integer.MIN_VALUE,max2=Integer.MIN_VALUE,max3=Integer.MIN_VALUE;
        for (int x:nums){
            if(x<min1){
                min2=min1;
                min1=x;
            }else if(x<min2){
                min2=x;
            }

            if(x>max1){
                max3=max2;
                max2=max1;
                max1=x;
            }else if (x>max2){
                max3=max2;
                max2=x;
            }else if (x>max3){
                max3=x;
            }
        }
        return Math.max(min1*min2*max1,max1*max2*max3);
    }
    }
