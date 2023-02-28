package com.example.leetcode.hot;

public class NumTree {
    /**
     *不同的二叉搜索树
     * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？
     * 返回满足题意的二叉搜索树的种数。
     * 二叉搜索树：左孩子<root && root>右孩子
     * 输入：n = 3
     * 输出：5
     * https://leetcode.cn/problems/unique-binary-search-trees/?favorite=2cktkvj
     */

    /**
     * 动态规划
     * G(n)表示n个结点有多少个二叉搜索树
     * f(i)表示第i个节点有多少种可能：G(i-1)*G(n-i)
     * G(n)=f(i)从1-n求和
     */
    public int numTrees(int n){
        int G[]=new int[n+1];
        G[0]=1;
        G[1]=1;
        for(int i=2;i<=n;i++){
            for (int j=1;j<=i;j++){
                G[i]+=G[j-1]*G[i-j];
            }
        }
        return G[n];
    }
}
