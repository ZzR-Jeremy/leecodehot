package com.example.leetcode.hot;

import java.util.ArrayList;
import java.util.List;

public class SubSet {
    /**
     *给定一个整数数组 返回这个数组所有可能的子集
     * @param nums
     * @return
     */
    //每个元素都有两种状态 0表示不在子集中 1表示在子集中
    //迭代法实现子集枚举
    public List<List<Integer>> subSets1(int[] nums){
        List<Integer> path=new ArrayList<>();
        List<List<Integer>> res=new ArrayList<>();
        int len=nums.length;
        for (int mask=0;mask<(1<<len);mask++){
            path.clear();
            for (int i=0;i<len;i++){
            if ((mask&(1<<i))!=0){
                path.add(nums[i]);
            }
        }
            res.add(new ArrayList<>(path));
        }
        return res;
    }
    public List<List<Integer>> subSets2(int[] nums){
        List<Integer> path=new ArrayList<Integer>();
        List<List<Integer>> res=new ArrayList<>();
        backtrack(0,nums,res,path);
        return res;
    }
    private void backtrack(int startIndex,int[] nums,List<List<Integer>> res,List<Integer> path){
        res.add(new ArrayList<>(path));
        if (startIndex>=nums.length){
            return;
        }
        //因为子集无关元素顺序，取过的元素不会重复取，所以循环要从startIndex开始，而不是从0开始
        //循环是横向遍历、递归是纵向遍历
        for (int j=startIndex;j<nums.length;j++){
            path.add(nums[j]);
            backtrack(j+1,nums,res,path);
            path.remove(path.size()-1);
        }
    }
    //递归
    public List<List<Integer>> subSets3(int[] nums){
        List<List<Integer>> res=new ArrayList<>();
        res.add(new ArrayList<Integer>());

        for (int num:nums){
            List<List<Integer>> newRes=new ArrayList<>();
            for (List<Integer> subset:res){
                List<Integer> newSubset=new ArrayList<>(subset);
                newSubset.add(num);
                newRes.add(newSubset);
            }
            res.addAll(newRes);
        }
        return res;
    }

    }
