package com.example.leetcode.designmode.single;

//静态内部类实现
public class Holder {
    private Holder(){}
    public static Holder getInstance(){
        return InnerClass.HOLDER;
    }
    public static class InnerClass{
        private static final Holder HOLDER=new Holder();
    }
}
