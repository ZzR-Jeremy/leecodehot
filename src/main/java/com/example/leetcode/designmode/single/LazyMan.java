package com.example.leetcode.designmode.single;

/**
 * 饿汉式每次创建都会先申请资源 这样可能导致了资源浪费问题
 * 懒汉式单例 就是为了解决这种问题而产生的
 * 需要的时候再申请资源
 */

public class LazyMan {
    private LazyMan(){}
    private volatile static LazyMan lazyMan;
    //双重检测锁模式 懒汉式单例 DCL懒汉式
    public static LazyMan getInstance(){
        if (lazyMan==null){
            synchronized (LazyMan.class){
                if (lazyMan==null){
                    /**
                     * 分配内存空间
                     * 执行构造方法，初始化对象
                     * 把这个对象指向这个空间
                     * 不是一个原子操作所以要用volatile关键字
                     */
                    lazyMan=new LazyMan();

                }
            }
        }
        return lazyMan;

    }

}
