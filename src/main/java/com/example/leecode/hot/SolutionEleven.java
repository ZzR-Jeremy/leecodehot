package com.example.leecode.hot;

import com.sun.javafx.collections.MappingChange;
import sun.text.normalizer.UCharacter;

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
}
