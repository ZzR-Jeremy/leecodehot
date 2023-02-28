package com.example.leetcode.hot;

import java.util.Deque;
import java.util.LinkedList;

/**
 *接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */

public class SolutionTwenty {
    /**
     * 动态规划
     * 对于下标i处所能接到的雨水量，等于左右两边最大高度的最小值-当前高度
     * 对数组中的每个元素向左向右扫描最大高度、
     * 创建两个长度为 nn 的数组 leftMax 和 rightMax。
     * 对于0≤i<n，leftMax[i] 表示下标 i 及其左边的位置中 height 的最大高度，
     * rightMax[i] 表示下标 i 及其右边的位置中，height 的最大高度。
     */
    public int trap(int[] height){
        int n=height.length;
        if(n==0) {
            return 0;
        }
        int[] leftMax=new int[n];
        leftMax[0]=height[0];
        for(int i=1;i<n;++i){
            leftMax[i]=Math.max(leftMax[i-1],height[i]);
        }
        int[] rightMax=new int[n];
        rightMax[n-1]=height[n-1];
        for (int j=n-2;j>=0;--j){
            rightMax[j]=Math.max(rightMax[j+1],height[j]);
        }
        int ans=0;
        for(int i=0;i<n;++i){
            ans+=Math.min(leftMax[i],rightMax[i])-height[i];
        }
        return ans;
    }
    /**
     * 单调递减栈
     * 维护一个单调栈，存储的是下标从栈底到栈顶height递减
     * 从左到右遍历，遍历到下标i时，如果栈内至少有两个元素记栈顶元素为top，一定有height[left]>=height[top]
     * 若height[i]>height[top]则可以成功蓄水，宽度为：i-left-1,高度为min(height[left],height[i])-height[top],
     */
    public int trap1(int[] height){
        int ans=0;
        Deque<Integer> stack=new LinkedList<Integer>();
        int n=height.length;
        for (int i=0;i<n;++i){
            while (!stack.isEmpty()&&height[i]>height[stack.peek()]){
                int top=stack.pop();
                if (stack.isEmpty()) break;
                int left=stack.peek();
                int currWidth=i-left-1;
                int currHeight=Math.min(height[i],height[left])-height[top];
                ans+=currHeight*currWidth;
            }
            stack.push(i);
        }
        return ans;
    }
    /**
     * 双指针
     * 下标i处能接到的雨水量是由leftMax[]和rightMax[]中最小值决定的，前者从左往右计算，后者从右往左计算
     * 维护两个指针取代替数组，left只会向右移动，right只能向左移动
     */
    public int trap2(int[] height){
        int ans=0;
        int left=0,right=height.length-1;
        int leftMax=0,rightMax=0;
        while(left<right){//loop终止条件
            //从左边开始遍历记录左侧最大值
            leftMax=Math.max(leftMax,height[left]);
            //从右边开始遍历记录右侧最大值
            rightMax=Math.max(rightMax,height[right]);
            //哪边有挡板就从他的反方向开始遍历
            if(height[left]<height[right]){
                ans+=leftMax-height[left];
                left++;
            }else{
                ans+=rightMax-height[right];
                right--;
            }
        }
        return ans;
    }
}
