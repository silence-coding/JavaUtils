package com.kangtian.util.sort;

/**
 * User: FIRE
 * Date: 2018/9/9
 * Description:
 */
public class QuickSort {
    public static void sort(int[] arr,int s,int e){
        if (s<e) {
            int p = getPoit(arr, s, e);
            sort(arr, s, p - 1);
            sort(arr, p + 1, e);
        }
    }
    public static int getPoit(int[] arr,int s,int e){
        int tem=arr[s];
        while (s<e){
            while (s<e&&arr[e]>=tem)
                e--;
            arr[s]=arr[e];//小的移到左边
            while (s<e&&arr[s]<=tem)
                s++;
         arr[e]=arr[s];
        }
        arr[s]=tem;
        return s;
    }
}