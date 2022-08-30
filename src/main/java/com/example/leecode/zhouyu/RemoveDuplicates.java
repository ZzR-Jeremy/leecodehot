package com.example.leecode.zhouyu;

/**
 * 删除有序数组中的重复项
 * 原地删除有序数组中有序的元素，返回长度，不能使用额外的数组空间
 */
public class RemoveDuplicates {
    /**
     *双指针  数组本身没有提供删除方法
     * 快慢指针
     * 两个指针在一个循环中
     * 不相等就一块往后移动
     * 相等则 nums[i+1]=nums[j]，最后返回i
     */

    public int removeDuplicates(int[] nums){
        if(nums.length==0){
            return  0;
        }
        int i=0;
        for (int j=1;j<nums.length;j++){
            if(nums[i]!=nums[j]){
                i++;
                nums[i]=nums[j];
            }
        }
        return i+1;
    }
    /**
     * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
     *
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     */
    public int removeDuplicate1(int[] nums){
        if (nums.length<=2)
            return 2;
        int slow=2,fast=2;
        while(fast<nums.length){
            if (nums[slow-2]!=nums[fast]){
                nums[slow]=nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
