package com.kangtian.util.sort;

public class InsertSort {
    public static void sort(int[] arr){
        int len=arr.length,tem=0,j=0;
        for (int i=0;i<len;i++){
            tem=arr[i];
            for ( j=i;j>0&&arr[j-1]>tem;j--){//查找i插入的位置j，即j-1处大tem
                    arr[j]=arr[j-1];//将j到i-1处的所有元素向后挪一位
            }
            arr[j]=tem;//将原来i处的值赋给j处
        }
    }

}
