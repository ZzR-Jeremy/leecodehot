package com.example.leetcode.hot;

import com.example.leetcode.datastructure.TreeNode;

import java.util.*;

/**
 * 给定一个二叉树的根节点root，返回它的中序遍历
 * root=[1,null,2,3]
 * [1,3,2]
 * https://leetcode.cn/problems/symmetric-tree/description/
 */
public class InorderTraversal {
    //递归
    public List<Integer> inorderTraversal1(TreeNode root){
        List<Integer> res=new ArrayList<Integer>();
        inorder(root,res);
        return res;
    }
    public void inorder(TreeNode root,List<Integer> res){
        if (root == null) {
            return;
        }
        inorder(root.left,res);
        res.add(root.val);
        inorder(root.right,res);
    }
    //迭代，在迭代时隐式地维护了一个栈
    public List<Integer> inorderTraversal2(TreeNode root){
        List<Integer> res=new ArrayList<Integer>();
        Deque<TreeNode> stack=new LinkedList<TreeNode>();
        while(root!=null||!stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            root =stack.pop();
            res.add(root.val);
            root=root.right;
        }
        return res;
    }
}
