package com.kangtian.util.sort;

/**
 * User: FIRE
 * Date: 2018/9/9
 * Description:  O(n2)
 */
public class BubbleSort {
    public static void sort(int [] arr){
        int len=arr.length;
        int tem;
        for (int i=0;i<len-1;i++)
            for (int j=0;j<len-i-1;j++)
               //通过不断的比较arr j j+1处位置大小， 把大的数往后挪，
                // 每次都能保证将len-i个里的最大的挪到数组len-i处
                //如1 4 2 3 5 2  第一次，4和2换，4和3换 5和最后一个2换 。得1 2 3 4 2 5
                if (arr[j]>arr[j+1]){
                    tem=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=tem;
                }

    }

}