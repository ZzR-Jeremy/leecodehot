package com.example.leecode.hot;

public class SolutionFifteen {
    /**
     * 整数数组的一个 排列  就是将其所有成员以序列或线性顺序排列。
     *
     * 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
     * 整数数组的 下一个排列 是指其整数的下一个字典序更大(数值)的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
     *如果没有更大的数列则直接升序排列
     * 我们希望增加的幅度尽可能小
     * 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
     * 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
     * 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
     * 给你一个整数数组 nums ，找出 nums 的下一个排列。
     *
     * 必须 原地 修改，只允许使用额外常数空间
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/next-permutation
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        int n=0;
        if(nums==null || (n=nums.length) == 0) return;
        //从后往前查找第一次出现nums[i]<nums[i+1]的位置
        int i=n-2;
        while(i>=0&&nums[i]>=nums[i+1])
            i--;
        //如果i=-1,意味着一直遍历到i=1时依旧未找到前一个比后一个小的数,即整体降序
        if(i>=0){
            //此时锁定了nums[i],现在要从后向前查找第一个比ni大的数
            //因为有序所以可以用二分查找,输入的都是下标
            int j=binarySearch(nums,i+1,n-1,nums[i]);
            //交换 i,j下标所对应的值
            swap(nums,i,j);
        }
        reverse(nums,i+1,n-1);
    }
    //查找逆序数组nums中 大于nums[i]的最大下标
    private int binarySearch(int[] nums, int left, int right, int target){
        while(left<=right){
            //向右移动一位 等同于除二
            int mid=(left+right)>>1;
            if(nums[mid]>target){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return right;
    }
    private void swap(int[] nums, int i, int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
    private void reverse(int[] nums, int i, int j){
        while(i<j){
            swap(nums,i++,j--);
        }
    }
}
