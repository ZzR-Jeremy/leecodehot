package com.example.leetcode.hot;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 */
public class SolutionEight {
    public List<List<Integer>> threeSum(int[] nums){
        int n=nums.length;
        List<List<Integer>> ans =new ArrayList<List<Integer>>();
        for (int first=0;first<n;++first){
            //如果第一个数和上一次一样则跳出本次循环
            if(first>0&&nums[first]==nums[first-1])
                continue;
            int third=n-1;
            int target=-nums[first];
            for(int second=first+1;second<n;++second){
                if(second>first+1&&nums[second]==nums[second])
                    continue;
                while(second<third&&nums[second]+nums[third]>target)
                    third--;
                if(second==third){
                    break;
                }
                if(nums[second]+nums[third]==target){
                    List<Integer> list=new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }

            }
        }
        return ans;
    }
}
