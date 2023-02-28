package com.example.leetcode.hot;

public class MinPathSum {
    /**
     * 给定一个非负整数m*n的grid ，找出一条从左上到右下的路径使得路径上的数字总和最小
     * 动态规划
     * @param grid
     * @return
     */
    public int minPathSum(int [][] grid){
        int rows=grid.length,columns=grid[0].length;
        if (grid==null||rows==0||columns==0) return 0;
        int[][] dp= new int[rows][columns];
        //构建动态规划数组
        dp[0][0]=grid[0][0];
        //转移方程
        //第一列上的元素 只能从上方到达目标位置
        for (int i=1;i<rows;++i){
            dp[i][0]=dp[i-1][0]+grid[i][0];
        }
        //第一行上的元素只能从左侧到达目标位置
        for(int j=0;j<columns;++j){
            dp[0][j]=dp[0][j-1]+grid[0][j];
        }
        //为除去第一行第一列以外的其他元素设置转移方程
        for (int i=1;i<rows;++i){
            for (int j=1;j<columns;++j){
                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-i])+grid[i][j];
            }
        }
        return dp[rows][columns];
    }
}
