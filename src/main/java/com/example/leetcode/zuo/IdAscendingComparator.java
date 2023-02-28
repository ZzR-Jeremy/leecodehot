package com.example.leetcode.zuo;

//比较器
public class IdAscendingComparator implements Comparable<Student>{

    /**
     * 返回负数时 第一个参数排在前面
     * 返回正数时第二个参数排在前面
     * 返回0时 谁在前面无所谓
     */
    //id 升序id晓得在前面
    public int compare(Student o1,Student o2) {
        return o1.getId()- o2.getId();
    }

    @Override
    public int compareTo(Student o) {
        return 0;
    }
}
