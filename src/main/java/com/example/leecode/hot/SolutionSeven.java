package com.example.leecode.hot;

/**
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 *
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 返回容器可以储存的最大水量。
 *
 * 说明：你不能倾斜容器
 */
public class SolutionSeven {
    public int maxArea(int[] height){
        int l=0,r=height.length-1;
        int ans=0;
        while(l<r){
            int area=Math.min(height[l],height[r])*(r-l);
            ans=Math.max(area,ans);
            if(height[l]<=height[r])
                l++;
            else
                r--;
        }
        return ans;
    }
}
/**
 *暴力解法
 *         int len=height.length;
 *         int maxarea=0;
 *         for(int i=0;i<len;++i){
 *             for(int j=i+1;j<len;++j){
 *                 maxarea=Math.max(maxarea,Math.min(height[i],height[j])*(j-i));
 *             }
 *         }
 *         return maxarea;
 */
