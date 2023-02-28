package com.example.leetcode.hot;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SolutionEighteen {
    public int[] searchRange(int[] nums,int target){
        int leftIndex=binarySearch(nums,target-1);//第一个比target-1(小于target的第一个数)的位置
        int rightIndex=binarySearch(nums,target)-1;//第一个比target大的下标-1，就是最后一个target的位置
        if(leftIndex<=rightIndex&&nums[leftIndex]==target){
            return new int[] {leftIndex,rightIndex};
        }
        return new int[] {-1,-1};
    }

    //刚好大于target的下标
    public int binarySearch(int[] nums,int target){
        int left=0,right=nums.length-1,ans=nums.length;
        while(left <= right){
            int center=left+(right-left)/2;
            if(nums[center]>target) {
                right = center-1;
                ans=center;
            }
            else left=center+1;
        }
        return ans;
    }

    //左闭右开,寻找>=target的第一个
    public int binarySearch1(int[] nums,int target){
        int left=0,right=nums.length;
        while(left<right){
            int center=left+(right-left)/2;
            if(nums[center]>=target)
                right=center;
            else
                left=center+1;
        }
        return left;
    }
    public int[] searchRange1(int[] nums,int target){
        int leftIndex=binarySearch1(nums,target);
        int rightIndex=binarySearch1(nums,target+1);
        if(leftIndex==nums.length||nums[leftIndex]!=target)
            return new int[] {-1,-1};
        return new int[] {leftIndex,rightIndex-1};
    }
}
