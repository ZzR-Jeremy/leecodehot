package com.example.leecode.hot;

import com.sun.scenario.effect.Brightpass;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 最小覆盖子串
 * 给你一个字符串 s 、一个字符串 t 。
 * 返回 s 中涵盖 t 所有字符的最小子串。
 * 如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 ""
 * https://leetcode.cn/problems/minimum-window-substring/?favorite=2cktkvj
 * 示例
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
 */
public class MinWindows {
    /**
     * 滑动窗口：两个指针一个延伸当前窗口的r指针，一个用来收缩窗口的r指针
     * 当窗口包含 ttt 全部所需的字符后，如果能收缩，我们就收缩窗口直到得到最小窗口。
     */
    Map<Character,Integer> ori=new HashMap<Character,Integer>();
    Map<Character,Integer> cnt=new HashMap<Character,Integer>();
    public String minWindow(String s,String t){
        int tLen=t.length();
        for (int i=0;i<tLen;++i){
            char c=t.charAt(i);
            /**
             * getOrDefault(key,default) 若存在Key就返回对应的hash，否则返回给定的默认值
             *ori.getOrDefault(c,0)+1 表示看ori中有没有c如果有 返回对应的value+1，如果没有就为1
             * 用来统计字符串中每个字符的数量,用来统计t中字母的数量，放到ori里
             */
            ori.put(c,ori.getOrDefault(c,0)+1);
        }
        int l=0,r=-1;
        int len=Integer.MAX_VALUE, ansL=-1, ansR=-1;
        int sLen=s.length();
        while(r<sLen){
            ++r;
            if (r<sLen && ori.containsKey(s.charAt(r))){
                /**
                 * 统计当前遍历过的字母数量放到cnt里
                 * 如果cnt中每个字母的个数都不小于t中每个字母的个数，证明当前窗口是可行的
                 */

                cnt.put(s.charAt(r),cnt.getOrDefault(s.charAt(r),0)+1);
            }
            //先判断窗口是否是可行的，不可行就一点一点拓宽右窗口的边界
            while (check() && l<=r){
                /**
                 * 如果是可行的对窗口范围进行缩减，从左边界开始
                 */
                if (r-1+1<len){
                    len=r-l+1;
                    ansL=l;
                    ansR=l+len;
                }
                //抛去左边界处的数后窗口还可行,就变化窗口中对应字符的数量，并把左边界右移。
                if(ori.containsKey(s.charAt(l))){
                    cnt.put(s.charAt(l),cnt.getOrDefault(s.charAt(l),0)-1);
                }
                l++;
            }

        }

        return ansL==-1?"":s.substring(ansL,ansR);


    }
    //判断窗口是否可行，窗口中对应字符的数量不小于ori中对应的数量
    public boolean check(){
        //entry就是键值对，相当于把键值对整合成一个集合，Map.Entry里面包含getKey()和getValue()方法
        Iterator iter=ori.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry entry=(Map.Entry)iter.next();
            Character key=(Character) entry.getKey();
            Integer val=(Integer) entry.getValue();
            if(cnt.getOrDefault(key,0)<val){
                return false;
            }
        }
        return true;
    }
    public String minWindows1(String s,String t){
        Map<Character,Integer> window=new HashMap<Character,Integer>();
        Map<Character,Integer> need=new HashMap<Character,Integer>();
        for(char c:t.toCharArray())
            need.put(c,need.getOrDefault(c,0)+1);
            int left=0,right=0;
            int count=0;//窗口中符合need要求的数量
            int start=0;//符合最优解的起始位置
            int len=Integer.MAX_VALUE;//len用来记录最终窗口的长度

        //一次遍历出可行解
        while(right<s.length()){
            char c=s.charAt(right);
            right++;
            if(need.containsKey(c)){
                window.put(c,need.getOrDefault(c,0)+1);
                if (need.get(c).equals(window.get(c))){
                    count++;
                }
            }
            //缩减左边界，找到符合条件的最优解
            while(count==need.size()){
                if (right-left<len){
                    len=right-left;
                    start=left;
                }
                char d=s.charAt(left);
                left++;
                if(need.containsKey(d)){
                    if (need.get(d).equals(window.get(d))){
                        count--;
                    }
                    window.put(d,window.get(d)-1);
                }
            }
        }
        return len==Integer.MAX_VALUE?"":s.substring(start,start+len);

    }

}
