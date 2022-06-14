package com.example.leecode.hot;

import java.util.*;

/**
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 *
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。 
 *
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个
 *
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 * 解释：
 * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
 * 7 也是一个候选， 7 = 7 。
 * 仅有这两种组合。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SolutionNineteen {
    public List<List<Integer>> combinationSum(int[] candidates,int target){
          int len=candidates.length;
          List<List<Integer>> results=new ArrayList<>();
          if(len==0){
              return results;
          }
          Deque<Integer> path=new ArrayDeque<>();//双端队列，即可当栈使用，也可以当队列使用
        //需要删除尾部元素时，最好使用Deque这个工具类，AD调用removeLast方法时维护了尾部元素，因此删除时 不需要像ArrayList那样每次都Copy一份
        dfs(candidates,0,len,target,path,results);
        return results;

    }
    public void dfs(int[] candidates,int satrtIndex, int length,int target,Deque<Integer> path,List<List<Integer>> results){
        if (target<0){
            return;
        }
        if (target==0){//满足条件收集结果
            results.add(new ArrayList<>(path));//把满足条件的path放到二维数组中
            return;
        }
        for (int i=satrtIndex;i<length;++i){//每个for循环都是对每一个节点的处理
            path.addLast(candidates[i]);
            //由于每一个元素都可以重复使用，下一轮搜索的起点仍然是i
            dfs(candidates, i, length, target-candidates[i], path, results);
            //回溯
            path.removeLast();
        }

    }

    /**
     * 剪枝提速
     * 如果target减去一个书得到负数，那么减去一个更大的数得到的仍是负数，同样搜索不到结果
     * 基于这个想法，可以对输入数据进行排序
     */
    public List<List<Integer>> combinationSum1(int[] candidates,int target){
        int length=candidates.length;
        List<List<Integer>> results=new ArrayList<>();
        if(length==0){
            return results;
        }
        Arrays.sort(candidates);
        Deque path=new ArrayDeque<>();
        dfs1(candidates,0,length,target,path,results);
        return results;
    }

    public void dfs1(int[] candidates,int startIndex,int length,int target,Deque<Integer> path,List<List<Integer>> results){
        if (target==0){
            results.add(new ArrayList<>(path));
            return;
        }
        for (int i=startIndex;i< length;++i){
            if(target-candidates[i]<0){
                break;
            }

            path.addLast(candidates[i]);
            dfs1(candidates,i,length,target-candidates[i],path,results);
            path.removeLast();
        }

    }
    public List<List<Integer>> permute(int[] nums) {//全排列 递归样例
        int len = nums.length;
        // 使用一个动态数组保存所有可能的全排列
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {//递归终止条件
            return res;
        }

        boolean[] used = new boolean[len];//判断路径是否已经选择过
        Deque<Integer> path = new ArrayDeque<>(len);

        dfs(nums, len, 0, path, used, res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth, Deque<Integer> path,
                     boolean[] used, List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            System.out.println("递归前i="+i);
            if (!used[i]) {//没被使用过
                path.addLast(nums[i]);
                used[i] = true;

                System.out.println("递归之前 => " + path);
                dfs(nums, len, depth + 1, path, used, res);
                System.out.println("递归后i="+i);
                used[i] = false;
                path.removeLast();
                System.out.println("递归之后 => " + path);
            }
        }
    }

}
