package com.kangtian.util.sort;

/**
 * User: FIRE
 * Date: 2018/9/9
 * Description:
 */
public class SelectSort {
    public static void sort(int [] arr){
        int len=arr.length;
        int tem=0;
        for (int i=0;i<len-1;i++){
                int p=i;
                int m=i;
            for (int j=len-1;j>i;j--){
               if (arr[j]<arr[p])//寻找剩下里面的最小值
                    p=j;
                if (arr[j]>arr[m])//寻找剩下里面的最大值
                    m=j;
            }
            tem=arr[p];//将最小值交换到i处。
            arr[p]=arr[i];
            arr[i]=tem;
            if (p!=m) {//避免最后的重复交换导致顺序错乱
                tem = arr[len - 1];//将最大值交换到len - 1处。
                arr[len - 1] = arr[m];
                arr[m] = tem;
                len--;//没交换一次，len减1
            }
        }
    }
    public static void sortSimple(int [] arr){
        int len=arr.length;  int tem=0;
        for (int i=0;i<len-1;i++){
            int p=i; int m=i;
            for (int j=len-1;j>i;j--){//寻找剩下里面的最小值
                if (arr[j]<arr[p])
                    p=j;
            }
            tem=arr[p]; //将最小值交换到i处。
            arr[p]=arr[i];
            arr[i]=tem;
        }
    }
}