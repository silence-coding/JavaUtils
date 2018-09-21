package com.kangtian.util.sort;

public class MergeSort {
    public static void sort(int[] arr){
        sort(arr,0,arr.length-1);
    }
    public static void sort(int[] arr,int start,int end){
        int mid=(start+end)/2;
        if (start<end){
            sort(arr,start,mid);//无限细分序列
            sort(arr,mid+1,end);
            merge(arr,start,mid,end);//合并序列（由于细分序列后的数组已是有序，归并后的数组故而也是有序的）
        }
    }
    public static void merge(int[] arr,int start,int mid,int end){
        int i=start,j=mid+1,k=0;
        int len=end - start + 1;
        int[] temp = new int[len];//辅助数组，利用空间换取移位的时间耗时
        while (i<=mid&&j<=end){//由于序列不一定等长，故会存在其中一个序列没有合并完
            if (arr[i]<arr[j])//合并序列
                temp[k++]=arr[i++];
            else
                temp[k++]=arr[j++];
        }
        while (i<=mid)//如果i<=mid即i到mid未合并完，合并该部分
            temp[k++]=arr[i++];
        while (j<=end)//如果j<=end即j到end未合并完，合并该部分
            temp[k++]=arr[j++];
        for ( i=0;i<len;i++) //将有序数据复值到原数组中
            arr[start++]=temp[i];
    }
}
