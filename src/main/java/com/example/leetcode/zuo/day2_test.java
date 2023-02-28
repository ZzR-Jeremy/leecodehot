package com.example.leetcode.zuo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 1.递归求最大值 逻辑上是一颗多叉树实际上是一个栈
 * 2.归并排序
 * 3.小和问题 13425 元素左边比他小的数之和
 * 4.求所有的逆序对数量
 * 5.荷兰国旗问题
 * 6.快排
 */
public class day2_test {
    //arr[L..R]范围上求最大值
    public static int getProcessMax(int[] arr){
        return process(arr,0,arr.length-1);
    }
    public static int process(int[] arr,int L,int R){
        if (L==R){
            return arr[L];
        }
        int mid=L+((R-L)>>1);//中点
        int leftMax=process(arr, L, mid);
        int rightMax=process(arr,mid+1,R);
        return Math.max(leftMax,rightMax);
    }

    /**
     * 归并排序
     * 数组一分为二 左右分别排好序
     * 然后新建一个辅助空间 对了两侧的元素进行merge
     * L M M+1 R
     */
    public static void process1(int[] array,int L,int R){
        if(L==R){
            return;
        }
        int mid=L+((R-L)>>1);
        //递归调用至二叉树两个相邻的叶子结点 将两个叶子结点进行合并
        process1(array,L,mid);
        process1(array,mid+1,R);
        merge(array,L,mid,R);

    }

    public static void merge(int[] array,int L,int M,int R){
        int[] help=new int[R-L+1];
        int i=0;
        int p1=L;
        int p2=M+1;
        while(p1<=M&&p2<=R){
            help[i++]=array[p1]<=array[p2]?array[p1++]:array[p2++];
        }
        //p2越界了 也就是证明右边的元素已经全归并完成了
        while(p1<=M){
            help[i++]=array[p1++];
        }
        while(p2<=R){
            help[i++]=array[p2++];
        }
        for (i=0;i<help.length;i++){
            array[L+i]=help[i];
        }
    }
    /**
     * 转换思路 右边几个数比本身大 就产生多少个本身的小和
     * 从左边转换成右边
     * 1 3 4 2 5
     * 采用归并排序的思路
     * 1 3 4 2 5
     *  1 3 4    2 5
     * 1 3   4  2   5
     * 1 3    4
     * 1   3
     * 先 1 3 merge 产生了一个1 的小和
     * 134  产生一个1 一个3
     */
    public static int smallSum(int[] arr){
        if(arr==null||arr.length<2){
            return 0;
        }
        return process3(arr,0,arr.length-1);
    }

    public static int process3(int[] arr,int L,int R){
        if (L==R) return 0;
        int mid=L+((R-1)>>1);
        return process3(arr, L, mid)
                +
                process3(arr,mid+1,R)
                +
                merge1(arr,L,mid,R);
    }

    private static int merge1(int[] arr, int l, int mid, int r) {
        int[] help=new int[r-l+1];
        int p1=l,p2=mid+1;
        int result=0;
        int i=0;
        while(p1<mid&&p2<r){
            result+=arr[p1]<arr[p2]?arr[r-p2+1]*arr[p1]:0;
            help[i++]=arr[p1]<arr[p2]?arr[p1++]:arr[p2++];
        }
        while(p1<=mid){
            help[i++]=arr[p1++];
        }
        while(p2<=r){
            help[i++]=arr[p2++];
        }
        for (i=0;i<help.length;i++){
            arr[l+i]=help[i];
        }
        return result;
    }

    /**
     *逆序对数量
     * 右边的数比左边的数大
     */
    private static int merge2(int[] arr, int l, int mid, int r) {
        int[] help=new int[r-l+1];
        int p1=l,p2=mid+1;
        int result=0;
        int i=0;
        while(p1<mid&&p2<r){
            result+=arr[p1]<arr[p2]?arr[r-p2+1]*arr[p1]:0;
            help[i++]=arr[p1]<arr[p2]?arr[p1++]:arr[p2++];
        }
        while(p1<mid){
            help[i++]=arr[p1++];
        }
        while(p2<r){
            help[i++]=arr[p2++];
        }
        for (i=0;i<help.length;i++){
            arr[l+i]=help[i];
        }
        return result;
    }
    /**
     * 荷兰国旗问题
     * 给定一个数组 arr和一个数num
     * 把小于num的放在数组的左侧 等于的放中间 大于的放在右侧
     * test1:简化版荷兰国旗问题
     * 小于的在右边大于的在左边
     */
    public  static void swap(int[] arr,int i,int j){
        arr[i]=arr[i]^arr[j];
        arr[j]=arr[i]^arr[j];
        arr[i]=arr[i]^arr[j];
    }
    public static void test1(int[] arr,int num){
        //小于等于num的边界
        int index=-1;
        for (int i=0;i<arr.length;++i){
            //遍历时如果比num小那与边界处的下一个交换
            if (arr[i]<=num){
                int temp=arr[i];
                arr[i]=arr[index+1];
                arr[++index]=temp;
            }
        }
    }
    public static void test2(int[] arr,int L,int R,int target){
        int less=L-1;
        int more=R+1;
        int index=L;
        while(index<more){
            if (arr[index]<target){
                swap(arr,++less,index++);
            }else if (arr[index]>target){
                swap(arr,--more,index);
            }else index++;
        }
    }

    /**
     * 快排
     * 随机选一个数给他放到数组的末尾位置
     * 选取末位位置的元素作为target以他做划分（荷兰国旗问题 左边的都比他小哦右边的都比他大，中间的等于他 然后把它和中间的数做换对）
     */
    public static void quickSort(int[] arr){

        if (arr == null || arr.length < 2) {
            return;
        }
        //开启快速排序
        quickSort(arr,0,arr.length-1);
    }

    public static void quickSort(int[] arr,int low,int high){
        int i,j,temp,t;
        if(low>high){
            return;
        }
        i=low;
        j=high;
        //temp就是基准位
        temp = arr[low];

        while (i<j) {
            //先看右边，依次往左递减，找一个比基准值小的
            while (temp<=arr[j]&&i<j) {
                j--;
            }
            //再看左边，依次往右递增，找一个比基准值大的
            while (temp>=arr[i]&&i<j) {
                i++;
            }
            //如果满足条件则交换
            if (i<j) swap(arr,i,j);

        }
        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;
        //递归调用左半数组
        quickSort(arr, low, j-1);
        //递归调用右半数组
        quickSort(arr, j+1, high);
    }


    public static void main(String[] args) {
        int[] array={5, 6, 7, 2, 3, 9};
        for (int i=0;i<array.length;i++)
        System.out.print(array[i]+" ");
        quickSort(array);
        for (int i=0;i<array.length;i++)
        System.out.print(array[i]);
    }
}



