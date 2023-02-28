package com.example.leetcode.hot;

import org.springframework.boot.context.event.SpringApplicationEvent;

import java.util.List;

/**
 * 排序汇总
 */
public class SortOrder {
    /**
     * 交换操作的三种实现
     * 对于冒泡、选择、插入等，经常要进行交换操作，
     */
    // 方法一：临时数tmp
    private void swapByTmp(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    //方法二：利用加减运算，可以以此来避免临时数的开销，但时可能会导致数字越界
    private void swapByCal(int[] arr, int i, int j) {
        arr[i] = arr[i] + arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] = arr[i] - arr[j];
    }

    /**
     * 方法三：利用异或运算，不仅减少了Tmp的开销，同时还避免了越界操作
     * 异或操作也称半加操作，可以理解为不带进位的二进制加法
     * 如果两个值不同，则异或结果为1，若两个值相同则异或结果为0
     * 将两数异或的结果与其中一数再进行异或，可以得到另一个数。
     * 任意一个二进制位与1异或都会转变成自己的相反位
     * 两数异或的结果保存了两个数上每一个二进制位不同或相同的信息，若两数相同标志为0，反之则为1
     * <p>
     * 注意：有的人说 在利用异或运算交换两数时，如果两数相等，则不能实现交换。
     * 这种说法是错误的，a=a^b=0,经一次运算后其中一个数变为0，另一个数保持不变，任何数和0运算都等于它本身
     */
    private void swapByXOR(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];//存储二者相同二进制位上相同或不同的信息，相当于进行不进位的二进制加法
        arr[j] = arr[i] ^ arr[j];//不同的话记为1，1代表不同，所以1与其中一个做运算就可以让他变成他的相反位，所以由此就可以推出另一个数的信息
        arr[i] = arr[i] ^ arr[j];//第一次运算的结果实际上就是对两个数的二进制数列中 不同的位置的一种标记
    }

    /**
     * 冒泡排序
     * 从第一位开始从前往后比较相邻的两个数字，若前者大则交换两数位置，由此就可以将每次遍历中最大的那个数堆叠至序列的尾部
     * 冒泡排序是稳定的：相等元素在原序列中的顺序在经过排序后不会改变。
     * <p>
     * 时间复杂度O（n^2）：两轮for循环，第一轮比较N-1次，最后一轮比较1次，等差数列求和：
     * （N-1）*N/2,当输入数组为已排序状态时，在应用提前结束优化的情况下，只需比较一轮即O（N）。
     * <p>
     * 空间复杂度：算法中只有常数项变量，O（1）。
     */
    //提前结束优化：若某一轮比较均为发生变化，说明排序已完成，可设置一个布尔值记录一轮排序是否发生交换，若无则提前退出循环结束程序
    public int[] bubbleSortFirst(int[] arr) {
        if(arr.length<2) return arr;
        //n个数只需要把n-1个数进行归为 最后一个数就自动归位了所以是 length-1
        for(int i=0;i<arr.length-1;i++){
            boolean swapped=false;
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j+1]<arr[j]){
                    swapByTmp(arr,j+1,j);
                    swapped=true;
                 }
                //如果没有进行交换，则证明已经有序
                if(!swapped) break;
            }
        }
        return arr;
    }
    public int[] bs(int[] arr){
        if(arr.length<2) return arr;
        boolean swapped=false;
        for (int i=0;i<arr.length;++i){
            for (int j=0;j<arr.length-i-1;++j){
                if (arr[j]>arr[j+1]) {
                    swapByXOR(arr, arr[j], arr[j + 1]);
                    swapped=true;
                }
                if (!swapped) break;
                }
        }
        return arr;
    }


    //冒泡边界优化：记录前一轮交换的最终位置，说明该位置之后的元素为已排序状态，下一轮交换只需执行到该处
    public int[] bubbleSortSecond(int[] arr) {
        if (arr.length < 2) return arr;
        boolean swapped = true;
        int lastSwappedIdx = arr.length - 1;
        int swappedIdx = -1;
        //lastSwappedIdx表示前一轮交换的最终位置，即下标为lastSwappedIdx是为排序部分中的最后一个数的下标，
        //因此for循环中的边界是i<lastSwappedIdx，而不是i<=lastSwappedIdx
        while (swapped) {//swapped=false时跳出循环
            swapped = false;
            for (int i = 0; i < lastSwappedIdx; i++) {
                if (arr[i] > arr[i + 1]) {
                    swapByXOR(arr, i, i + 1);
                    swapped = true;
                    swappedIdx = i;
                }
            }
            lastSwappedIdx = swappedIdx;
        }
        return arr;
    }


    /**
     * 选择排序
     * 设置一个minIdx记录最小数字的下标，假定arr[0]处的数字最小，第一轮循环时让他与后面的每一个元素都进行比较
     * 如果发现有比他小的，就把小的那个放到arr[0]的位置，简单来讲就是不断地把最小的元素推叠至队首
     */
    //单元选择排序
    public int[] selectSortFirst(int[] arr){
        if (arr.length<2) return arr;
        int minIdx=0;
        for (int i=0;i<arr.length-1;++i){
            minIdx=i;
            //获取本轮中最小那个数的下标 用minidx寄存
            for (int j=i;j<arr.length;++j){
                if(arr[minIdx]>arr[j])
                minIdx=j;
            }
            //若本轮第一个数字不是最小值，则交换位置
            if(minIdx!=i) swapByXOR(arr,i,minIdx);
        }
        return arr;
    }


    /**
     *双元选择排序
     * 在遍历寻找最小值下标minIdx时，同时寻找最大值下标maxIdx,这样就可以一轮遍历确定两个元素的位置
     * 遍历次数减少一半，但是每轮操作会变多，只能少量提升速度
     * 选择排序是不稳定的
     *
     * 时间复杂度 O（n^2）：两层for循环第一轮比较n-1次,最后一轮比较1次
     *
     * 空间复杂度 O（1）：只有常数项
     */
    public int[] selectSortSecond(int arr[]){
        if(arr.length<2) return arr;
        int minIdx,maxIdx;
        //每轮确定两个数字，因此界也会动态变化
        for(int i=0;i<arr.length-1-i;++i){
            minIdx=i;
            maxIdx=i;
            for (int j=i;j<arr.length-i;j++){
                if (arr[minIdx]>arr[j]) minIdx=j;
                if (arr[maxIdx]<arr[j]) maxIdx=j;
            }
            //若最大值等于最小值，说明序列所有元素相等
            if (minIdx==maxIdx) break;
            if (minIdx!=i) swapByXOR(arr,i,minIdx);
            //在交换i和minIdx时，可能出现I即maxIdx的情况，此时需要修改maxIdx为minIdx
            if(maxIdx==i) maxIdx=minIdx;
            if (maxIdx!=i) swapByTmp(arr,arr.length-1-i,maxIdx);
        }
        return arr;
    }

    public int[] dummy(int[] array){
        if(array.length<2) return array;
        int minIdx,maxIdx;
        for (int i=0;i<array.length-i;++i){
            minIdx=i;
            maxIdx=i;
            for (int j=i;j<array.length-i;++j){
                if (array[minIdx]>array[j]) minIdx=j;
                if (array[maxIdx]<array[i]) maxIdx=i;
            }
            if (minIdx==maxIdx) break;
            if (minIdx!=i) swapByXOR(array,minIdx,i);
            if (maxIdx==i) maxIdx=minIdx;
            if (maxIdx!=i) swapByXOR(array,array.length-i-1,maxIdx);
        }
        return array;
    }

    /**
     * 插入排序
     * 从第2个元素开始，比较它与之前的元素，当插入的元素小于比较的元素时，继续往前比较，直到不小于比较对象，此时
     * 就将插入元素插入至比较元素之后，重复此操作直到，最后一个元素完成插入操作。
     * 插入排序是稳定的，因为条件是(>=),所以后插入的相等对象，非（不小于），不满足条件所以后安置在比较对象右边
     */
    //简单插入排序
    public int[] insertSort(int[] arr){
        if(arr.length<2) return arr;
        int n=arr.length;
        for (int i=1;i<n;i++){
            int target=arr[i];
            int j=i-1;
            for(;j>=0;j--){
                if (target<arr[j])
                    arr[j+1]=arr[j];
                else break;
            }
            //j变动表示发生了移动，此时插入对象的>=j位置的数字，故插入位置为j+1
            if(j!=i-1) arr[j+1]=target;
        }
        return arr;
    }
    public int[] insertSort1(int[] arr){
        if(arr.length<2) return arr;
        for (int i=1;i<arr.length;++i){
            int target=arr[i];
            int j=i-1;
            for (;j>=0;j--){
                if(target<arr[j])
                    arr[j+1]=arr[j];
                    else break;
            }
            //循环结束后j=-1
            if (j!=i+1) swapByXOR(arr,target,arr[j+1]);

        }
        return arr;
    }
    /**
     * 折半插入排序
     * 插入排序每完成一轮，都会使第一个元素到该元素为排序状态，因为是有序的所以可以对相对有序的序列进行
     * 二分查找，折半插入，显著的减少比较次数
     *
     * 简单插入排序和二分插入排序都是稳定的
     *
     * 时间复杂度O（n^2）两层for循环
     * 空间复杂度O（1）
     */
    public int[] insertSortBinary(int[] arr){
        if(arr.length<2) return arr;
        for(int i=1;i<arr.length;i++){
            //若插入对象大于等于前一个对象，无需插入
            if(arr[i-1]<=arr[i]) continue;
            int target=arr[i];
            //折半查找
            int l=0,r=i-1;
            //while结束后，target要插入的位置为low或high+1
            while(l<=r){
                int center=l+(r-l)/2;
                if(arr[center]<=target) l=center+1;
                else r=center-1;
            }
            for (int j=i;j>l;j--){//移动
                arr[j]=arr[j-1];
            }
            arr[l]=target;//插入
        }
        return arr;
    }
    public int[] zhecha(int[] arr){
        if(arr.length<2) return arr;
        int target;
        for(int i=1;i<arr.length;i++){
            if(arr[i]>arr[i-1]) continue;
            target=arr[i];
            int left=0,right=i-1;
            while(left<=right){
                int center=left+(right-left)/2;
                if(target<arr[center]) right=center-1;
                else left=center+1;
            }
            for (int j=i;j>left;j--){
                if (target<arr[j])
                    arr[j]=arr[j-1];
            }
            arr[left]=target;
        }
        return arr;
    }
     public static int[] quickSort(int[] arr,int l,int r){
        if(arr.length<2) return arr;
        int left=1,right=r-1;
        int target=arr[left];
        while(left<right){
            while(left<right&&target<arr[right]){
                right--;
            }
            arr[left]=arr[right];
            while(left<right&&target>arr[left]){
                left++;
            }
            arr[right]=arr[left];
        }
        arr[left]=target;
        if(left>l) quickSort(arr,l,left);
        if (left+1<r) quickSort(arr,left+1,r);
        return arr;
     }
    public void dummy(int[] array,int start,int last){

        int left=start,right=last;
        int target=array[start];
        while(left<right){
            while(left<right&&target<=array[right]) right--;
            while(left<right&&target>=array[left]) left++;
            if (left<right) swapByXOR(array,left,right);
        }
        swapByXOR(array,start,left);
        dummy(array,start,left-1);
        dummy(array,left+1, last);
    }

        public void quickSort1(int[] arr,int start,int end){
        if(arr.length<2) System.out.println("无需排序");
        int i=start,j=end;
        int target=arr[start];
        while(i<j){
            while(i<j&&target<=arr[j]) j--;
            while(i<j&&target>=arr[i]) i++;
            //从右往左找比他小的，从左往右找比他大的，找到之后调换
            if(i<j) swapByXOR(arr,i,j);
        }
        //target归位到i=j的位置
        swapByXOR(arr,start,i);
        quickSort1(arr,start,j-1);
        quickSort1(arr,j+1,end);
     }
     public void qs(int[] arr,int left,int right){
        if(arr.length<2) System.out.println("2");
        int l=left,r=right;
        int target=arr[left];
        while(l<r){
            while(l<r&&target<=arr[r]) r--;
            while(l<r&&target>=arr[l]) l++;
            if(l<r) swapByXOR(arr,l,r);
        }
        swapByXOR(arr,left,l);
        qs(arr,left,r-1);
        qs(arr,r+1,right);
     }
     public int searchBinary(int[] arr,int target){
        int left=0,right=arr.length;
        while(left<=right){
            int center=left+(right-left)/2;
            if (target==arr[center]) return center;
            else if (target<=arr[center]) right=center-1;
            else left=center+1;
        }
        return -1;
     }
     public int sb(int[] arr,int target){
        int left=0,right=arr.length-1;
        while(left<=right){
            int cen=left+(right-left)/2;
            if(cen==target) return 1;
            else if(target<=arr[cen]) right=cen-1;
            else left=cen+1;
        }
        return -1;

     }
     //链表后置
    public ListNode reverseList(ListNode head){
        ListNode pre=null;
        ListNode cur=head;
        while(cur!=null){
            ListNode next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;
    }

}
