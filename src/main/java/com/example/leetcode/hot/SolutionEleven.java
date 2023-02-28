package com.example.leetcode.hot;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SolutionEleven {
    public boolean isValid(String s) {
        int n=s.length();
        if(n%2==1) return false;//字符串长度为奇数的话直接报错
        Map<Character,Character> pairs=new HashMap<Character, Character>(){{//Map <key,value>
            put(')','(');
            put(']','[');
            put('}','{');
        }};
        Deque<Character> stuck=new LinkedList<Character>();
        for(int i=0;i<n;++i){
            char ch=s.charAt(i);
            if(pairs.containsKey(ch)){
                if(stuck.isEmpty()||stuck.peek()!=pairs.get(ch))//返回栈顶不弹出
                    return false;
                stuck.pop();//返回栈顶元素并弹出
            }else{
                stuck.push(ch);
            }
        }
        return stuck.isEmpty();
    }
    public boolean isValid1(String s){
        int n=s.length();
        if (n%2!=0) return false;
        Map<Character,Character> pairs=new HashMap<>(){{
            put(')','(');
            put(']','[');
            put('}','{');
        }};
        Deque<Character> stack=new LinkedList<>();
        for (int i=0;i<n;i++){
            char c=s.charAt(i);
            if (pairs.containsKey(c)){
                if (stack.isEmpty()||stack.peek()!=pairs.get(c))
                    return false;
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
