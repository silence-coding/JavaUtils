package com.kangtian.util.sort;

public class MergeSort {
    public static void sort(int[] arr){
        sort(arr,0,arr.length-1);
    }
    public static void sort(int[] arr,int start,int end){
        int mid=(start+end)/2;
        if (start<end){
            sort(arr,start,mid);
            sort(arr,mid+1,end);
            merge(arr,start,mid,end);
        }
    }
    public static void merge(int[] arr,int start,int mid,int end){
        int i=start,j=mid+1,k=0;
        int len=end - start + 1;
        int[] temp = new int[len];
        while (i<=mid&&j<=end){
            if (arr[i]<arr[j])
                temp[k++]=arr[i++];
            else
                temp[k++]=arr[j++];
        }
        while (i<=mid)
            temp[k++]=arr[i++];
        while (j<=end)
            temp[k++]=arr[j++];
        for ( i=0;i<len;i++)
            arr[start++]=temp[i];
    }
}
