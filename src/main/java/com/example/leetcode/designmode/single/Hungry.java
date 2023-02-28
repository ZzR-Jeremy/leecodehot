package com.example.leetcode.designmode.single;

import com.example.leetcode.zuo.Signleton;

/**
 * 单例模式
 * 保证一个系统中一个类只有一个对象实例
 * 节省资源、方便控制
 * 1.构造器私有：保证一个类不能被实例化，组织对象被new出来，把类的所有构造方法私有化
 * 2.以静态方法返回实例：外界不能通过new获取对象
 * 3.确保对象的实例化只有一个：以后直接获取第一次实例化的对象
 */
//饿汉模式
public class Hungry {
    //先创建好对象
    private static final Hungry hungry=new Hungry();
    //构造方法私有化
    private Hungry(){

    }
    //其他人来拿直接返回已经创建好的
    public static Hungry getInstance(){
        return hungry;
    }
}
