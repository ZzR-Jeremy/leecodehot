package com.example.leetcode.hot;

import com.example.leetcode.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class IsValidBST {
    /**
     * 验证二叉搜索树
     * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
     *
     * 有效 二叉搜索树定义如下：
     * 节点的左子树只包含 小于 当前节点的数。
     * 节点的右子树只包含 大于 当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树。
     * https://leetcode.cn/problems/validate-binary-search-tree/solutions/?favorite=2cktkvj
     * @return
     */

    /**
     * 借助中序遍历解决
     * 先求得中序遍历的序列
     * 然后再判断序列中的前驱是不是都严格小于当前结点
     */
    List<Integer> result=new ArrayList<Integer>();
    public boolean isValidBST(TreeNode root){
        inorder(root,result);
        for (int i=1;i<result.size();++i){
            if (result.get(i)<=result.get(i-1)){
                return false;
            }
        }
        return true;
    }
    private void inorder(TreeNode root, List<Integer> result){
        if (root==null) return;
        inorder(root.left,result);
        result.add(root.val);
        inorder(root.right,result);
    }
    /**
     * 递归法解决：
     * 递归函数：helper(node,l,r)
     * 左子树不空，左子树中的所有结点均小于root，helper(node.left,l,node)
     * 右子树不空，右子树中的所有结点均大于root，helper(node.right,node,r)
     */
    public boolean isValidBST1(TreeNode root){
        return isValidBST1(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public boolean isValidBST1(TreeNode root,long left,long right){
        if (root==null) return true;
        if (root.val<=left||root.val>=right) return false;
        return isValidBST1(root.left,left,root.val)&&isValidBST1(root.right,root.val,right);
    }
}
