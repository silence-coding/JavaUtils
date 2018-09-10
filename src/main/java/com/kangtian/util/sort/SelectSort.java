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
            for (int j=len-1;j>i;j--){
               if (arr[j]<arr[p])
                   p=j;
            }
            tem=arr[p];
            arr[p]=arr[i];
            arr[i]=tem;
        }
    }
}