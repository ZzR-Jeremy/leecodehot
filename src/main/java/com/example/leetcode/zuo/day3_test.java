package com.example.leetcode.zuo;

import java.util.ArrayList;
import java.util.List;

/**
 * 1.堆的交换
 * 2.全排列
 */
public class day3_test {
    public static void heapify(int[] arr,int index,int heapSize){
        int left=index*2+1;
        //判断有没有孩子，左孩子不越界一定有孩子 如果左孩子越界了证明一定没有孩子
        while (left<heapSize){
            //谁大把下标给largest
            int largest=left+1<heapSize&&arr[left+1]>arr[left] ? left+1:left;
            largest=arr[largest]>arr[index]?largest:index;
            if (largest==index) break;
            day2_test.swap(arr,largest,index);
            //index 往下走
            index=largest;
            left=2*index+1;
        }
    }
    //大根堆插入
    public static void heapInsert(int[] arr,int index){
        //当前结点和父节点作比较
        while(arr[index]>arr[(index-1)/2]){
            day2_test.swap(arr,index,(index-1)/2);
            index=(index-1)/2;
        }
    }

    public List<List<Integer>> permute(int[] nums){
        List<Integer> path=new ArrayList<>();
        List<List<Integer>> result=new ArrayList<>();
        int len=nums.length;
        boolean[] used=new boolean[len];
        dfs(nums,0,len,path,result,used);
        return result;
    }

    private static void dfs(int[] arr, int depth, int length, List<Integer> path,List<List<Integer>> result,boolean[] used){
        if (depth==length){
            result.add(new ArrayList<>(path));
            return;
        }
        //全排列问题从0开始
        for (int i=0;i<length;i++){
            if (!used[i]){
                path.add(arr[i]);
                used[i]=true;
                dfs(arr, depth+1, length, path, result, used);
                //回到浅层结点
                used[i]=false;
                path.remove(path.size()-1);
            }
        }
    }
    /**
     * 排序算法的稳定性 可以保证次序
     */
}
