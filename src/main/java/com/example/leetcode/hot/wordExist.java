package com.example.leetcode.hot;

public class wordExist {
    //方向 上 左 右 下
    private static final int[][] DIRECTIONS={{-1,0},{0,-1},{0,1},{1,0}};
    private int rows;
    private int cols;
    private int len;
    //是否遍历过
    private boolean[][] visited;
    private char[] charArray;
    private char[][] board;

    public boolean exist(char[][] board,String word){
        rows=board.length;
        if (rows==0) return false;
        cols=board[0].length;
        visited=new boolean[rows][cols];
        this.len=word.length();
        this.charArray=word.toCharArray();
        this.board=board;
        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                if (dfs(i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int begin) {
        if (begin==len-1){
            return board[i][j]==charArray[begin];
        }
        if (board[i][j]==charArray[begin]){
            visited[i][j]=true;
            for (int[] direction:DIRECTIONS){
                int newI=i+direction[0];
                int newJ=j+direction[1];
                if(inArea(newI,newJ)&&!visited[newI][newJ]){
                    if (dfs(newI,newJ,begin+1)){
                        return true;
                    }
                }
            }
            visited[i][j]=false;
        }
        return false;
    }

    private boolean inArea(int newI, int newJ) {
        return newI>=0&&newI<rows&&newJ>=0&&newJ<cols;
    }
}
