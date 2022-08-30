package com.example.leecode.hot;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SolutionTwentySix {
    public int[][] merge(int[][] intervals){
        List<int[]> result=new ArrayList<>();
        if(intervals.length==0||intervals==null)
            return result.toArray(new int[0][]);
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int i=0;
        while(i<intervals.length){
            int left=intervals[i][0];
            int right=intervals[i][1];
            while(i<intervals.length-1&&intervals[i+1][0]<=right){
                i++;
                Math.max(right,intervals[i][1]);
            }
            result.add(new int[]{left,right});
            i++;
        }
        return result.toArray(new int[0][]);

    }
}
