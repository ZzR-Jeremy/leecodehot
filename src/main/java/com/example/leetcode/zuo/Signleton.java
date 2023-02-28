package com.example.leetcode.zuo;

/**
 * Volatile 关键字
 * 指示JVM这个变量是共享且不稳定的
 * 每次使用它都要到主存中去读取 保证了变量的可见性
 * 禁止指令重排序
 * 如果我们将变量声明成了volatile
 * 对这个变量进行读写操作的时候会通过插入特定的内存屏障的方式来禁止指令的重排序
 */
public class Signleton {
    public static void main(String[] args) {
        int x=1,y=1,z=1;
        if(--x==0 && y++==1||z++==1)
            System.out.println("x="+x+",y=" +y+",z="+z);
    }
}
