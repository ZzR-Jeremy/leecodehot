package com.example.leetcode.zuo;

public class day1_test {
    /**
     * 1.一个数组中只有一种数出现了奇数次，其他一种数出现了偶数次
     * 2.只有两种数出现了奇数次，其他都出现了偶数次
     * 3.局部最小值问题 array无序任意两个相邻的数不相等
     */

    /**
     * 异或操作实现两个数交换
     * 0^x=x;
     * x^x=0;
     * 满足交换律结合律 相当于做不进位加法
     * @param array
     * @param i
     * @param j
     */
    public void xorSwapped(int[] array,int i,int j){
        array[i]=array[i]^array[j];
        array[j]=array[i]^array[j];
        array[i]=array[i]^array[j];
    }
    public void test1(int[] array){
        int eor=0;
        for (int arr:array){
            eor^=arr;
        }
        System.out.println(eor);
    }
    //从头异或到尾最后的结果一定是a^b,且一定有一位为一
    public void test2(int[] array){
        int eor1=0;
        for (int arr:array){
            //a^b 此时一定有一位为一 因为a!=b
            eor1^=arr;
        }
        //提取一个数最右侧的1
        int rightOne=eor1&(~eor1+1);
        //将数组分为两类 这两类一定有一位是不相同的 此时a和b一定分别在这两类之中
        int eor2=0;
        for (int arr:array){
            //按照数组中对应的位（a^b的结果中最右侧的一）把数组分为两类
            if((arr&rightOne)==0){//分类出来
                //a or b
                eor2^=arr;
            }
        }
        eor1^=eor2;
        System.out.println(eor1+" "+eor2);
    }
    //冒泡排序
    public int[] bubbleSort(int[] a){
        if (a.length<2) return a;
        int n=a.length;
        boolean swapped=false;
        for (int i=0;i<n-1;++i){
            for (int j=0;j<n-1-i;++j){
                if (a[j]>a[j+1]){
                    swapped=true;
                    a[j]=a[j]^a[j+1];
                    a[j+1]=a[j]^a[j+1];
                    a[j]=a[j]^a[j+1];
                }
            }
            if (!swapped) break;
        }
        return a;
    }
    //选择排序 每次选择最小的与每次遍历的队首做交换
    public int[] selectSort(int[] arr){
        int n=arr.length;
        if (n<2) return arr;
        int minIdx=0;
        for (int i=0;i<n-1;i++){
            minIdx=i;
            for (int j=i;j<n;j++){
                if (arr[minIdx]>arr[j]) minIdx=j;
            }
            if (minIdx!=i) xorSwapped(arr,i,minIdx);
        }
        return arr;
    }
        //插入排序 每次排前i个元素
    public int[] insertSort(int[] arr){
        int n=arr.length;
        if(n<2) return arr;
        int target=0;
        for (int i=1;i<n;i++){
            target=arr[i];
            int j=i-1;
            for (;j>=0;j--){
                if(target>arr[j])
                    arr[j+1]=arr[j];
                else break;
            }
            if (j+1!=i) {
                target=target^arr[j+1];
                arr[j+1]=target^arr[j+1];
                target=target^arr[j+1];
            }
        }
        return arr;
    }

    /**
     * 无序也可二分
     * 先判断两个端点是不是局部最小 若是就可以返回
     * 如果不是那么证明 0到n-1位置上一定存在一个拐点
     * 先取中点
     * @param arr
     */
    public static int test3(int[] arr){
        int n=arr.length;
        if (arr==null||n==0)  return -1;
        if (n==1) return 0;
        if (arr[0]<arr[1]) return 1;
        if (arr[n-1]<arr[n-2]) return n-1;
        int left=0, right=n-1;
        int mid;
        while(left<right){
            mid=left+(right-left)/2;
            if (arr[mid]>arr[mid-1]){
                right=mid-1;
            }else if(arr[mid]>arr[mid+1]){
                left=mid+1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {4,3,6,8,2,1,5,7};
        int res = test3(arr);
        if(res < 0) {
            System.out.println("最小值不存在");
        } else {
            System.out.println(arr[res]);
        }
    }
}
