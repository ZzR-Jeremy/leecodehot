package com.example.leetcode.hot;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 输入：n = 1
 * 输出：["()"]
 */
public class SolutionThirteen {
    /**
     * 回溯法 深度优先遍历
     * @param n
     * @return
     */
    public  List<String> generateParenthesis(int n) {
        List<String> res= new ArrayList<>();
        if(n<=0) return res;
        dfs(n,"",res,0,0);
        return  res;
    }
    private void dfs(int n, String path, List<String> res,int left, int right){
        if(left>n||right>left) return;
        if(path.length()==2*n){
            res.add(path);
            return;
        }
        dfs(n,path+"(",res,left+1,right);
        dfs(n,path+")",res,left,right+1);
    }
}
