package com.kangtian.util.sort;

public class InsertSort {
    public static void sort(int[] arr){
        int len=arr.length,tem=0,j=0;
        for (int i=0;i<len;i++){
            tem=arr[i];
            for ( j=i;j>0&&arr[j-1]>tem;j--){
                    arr[j]=arr[j-1];
            }
            arr[j]=tem;
        }
    }

}
