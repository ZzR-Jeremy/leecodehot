package com.example.leetcode.hot;

import com.example.leetcode.datastructure.TreeNode;

import java.util.LinkedList;

public class IsSymmetric {
    /**
     * 给定一颗二叉树检查是否是轴对称
     * 输入：root = [1,2,2,3,4,4,3]
     * 输出：true
     */
    //递归实现，比较左子树的左节点和右子树的右节点，再比较左子树的右节点和右子树的左节点
    public boolean isSymmetric(TreeNode root){
        if (root==null) return true;
        return dfs(root.left,root.right);
    }
    public boolean dfs(TreeNode left,TreeNode right){
        //左右都为空终止
        if (left==null&&right==null) return true;
        //左右有一个不为空证明二者不一致终止
        if (left==null||right==null) return false;
        //左右不同 false
        if (left.val!=right.val) return false;
        return dfs(left.left,right.right)&&dfs(left.right,right.left);
    }
    /**
     * 队列实现
     * 首先将左右子树放入队列进行比较
     * 接下来再将左子树的左 和 右子树的右放入队列
     * 之后再将左子树的右 和 右子树的左放入队列
     */
    public boolean isSymmetric1 (TreeNode root){
        if(root==null||(root.left==null&&root.right==null)) return true;
        LinkedList<TreeNode> queue=new LinkedList<TreeNode>();
        queue.add(root.left);
        queue.add(root.right);
        while(queue.size()>0){
            TreeNode left=queue.removeFirst();
            TreeNode right=queue.removeFirst();
            if (left==null&&right==null) continue;
            if (left==null||right==null) return false;
            if (left.val!= right.val) return false;
            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }

}
