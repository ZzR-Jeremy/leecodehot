package com.example.leetcode.hot;

public class SortColors {
    /**
     * 颜色分类
     * 共n个元素的数组，原地对他们进行排序，使得相同颜色的元素相邻，并按照红色白色蓝色的顺序排列 012
     * @param nums
     */

    //单指针 先把0归位，再把1归位
    public void sortColors1(int[] nums){
        int n=nums.length;
        int index=0;
        for (int i=0;i<n;++i){
            if (nums[i]==0){
                int temp=nums[i];
                nums[i]=nums[index];
                nums[index]=temp;
                ++index;
            }
        }
        for (int i=index;i<n;++i){
            if (nums[i]==1){
                int temp=nums[i];
                nums[i]=nums[index];
                nums[index]=temp;
                ++index;
            }
        }
    }

    //双指针同时把 0和2归位
    public void sortColors2(int[] nums){
        int n=nums.length;
        int index1=0,index2=n-1;
        for (int i=0;i<=index2;++i){
            while(i<=index2&&nums[i]==2){
                int temp1=nums[i];
                nums[i]=nums[index2];
                nums[index2]=temp1;
                --index2;
            }
            if (nums[i]==0){
                int temp=nums[i];
                nums[i]=nums[index1];
                nums[index1]=temp;
                ++index1;
            }
        }
    }
}
