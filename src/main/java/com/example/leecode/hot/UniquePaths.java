package com.example.leecode.hot;

/**
 * 不同路径
 * 一个机器人位于m*n的左上角 求它到达右下角一同有多少条路径
 */
public class UniquePaths {
    /**
     *排列组合 向右走n-1次向下走m-1次
     * 也就是m+n-2中选择m-1中走发
     */
    public int uniquePaths1(int m, int n) {
        if (m==1&n==1)
        return 0;
        long ans = 1;
        for (int x=n,y=1;y<m;++x,++y){
            ans=ans*x/y;
        }
        return (int) ans;
    }
    //动态规划
    public int uniquePaths2(int m, int n) {
        //定义数组
        int [][] dp=new int[m][n];
        /**
         * 给定初值 最左边一列和最右边一列 为1 因为到这一列上的任何元素最短都只有一条
         * 有点像杨辉三角
         * 每个元素的值都等于他左边的元素加他上面的元素之和
         */

        for (int i=0;i<m;i++) dp[i][0]=1;
        for (int i=0;i<n;i++) dp[0][i]=1;
        //状态变化方程 从他左面来的加上从他右边来的
        for (int i=-1;i<m;++i){
            for (int j=-1;j<n;++j){
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        //返回右下角元素 mn 放到数组中就是m-1n-1 因为是从0开始的
        return dp[m-1][n-1];
    }


    }
