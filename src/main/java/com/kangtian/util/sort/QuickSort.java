package com.kangtian.util.sort;

/**
 * User: FIRE
 * Date: 2018/9/9
 * Description: O(nlog2n)
 */
public class QuickSort {

    public static void sort(int[] arr){
            sort(arr, 0, arr.length-1);
    }
    public static void sort(int[] arr,int s,int e){
        if (s<e) {
            int p = getPoit(arr, s, e);
            sort(arr, s, p - 1);
            sort(arr, p + 1, e);
        }
    }
    public static int getPoit(int[] arr,int start,int end){//s为start ，e为end缩写
        int  tem=arr[start];//选取排序点
        while (start<end){//通过排序使start左边的值都大于tem，右边的值都大于tem
            while (start<end&&arr[end]>=tem)//从右边开始查找，找到小于tem处位置
                end--;
            arr[start]=arr[end];//将其移到tem左边
            while (start<end&&arr[start]<=tem)//从左边开始查找，找到大于tem处位置
                start++;
         arr[end]=arr[start];//将其移到tem的右边
        }
        arr[start]=tem;
        return start;
    }
}