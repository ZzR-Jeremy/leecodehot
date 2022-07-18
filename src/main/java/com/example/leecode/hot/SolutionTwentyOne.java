package com.example.leecode.hot;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
 */
public class SolutionTwentyOne {

    public void dfs(int[] nums, int len, int depth, boolean[] used, List<Integer> path,List<List<Integer>> result){
        if(depth==len){
            result.add(new ArrayList<>(path));
            return;
        }
        //在非叶子节点处选择一个未被使用的元素跳入下一个分支
        for(int i=0;i<len;++i){
            if(!used[i]){
                path.add(nums[i]);
                used[i]=true;
                //选择之后深度遍历
                dfs(nums, len, depth+1, used, path, result);
                //遍历之后回溯,还原现场
                used[i]=false;
                path.remove(path.size()-1);
            }
        }
    }
    public List<List<Integer>> permute(int[] nums){
        int len=nums.length;
        List<List<Integer>> result=new ArrayList<>();
        if(len==0){
            return result;
        }
        boolean[] used=new boolean[len];
        List<Integer> path=new ArrayList<>();
        dfs(nums,len,0,used,path,result);
        return result;
    }

}
