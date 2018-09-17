package com.kangtian.util.sort;

import java.util.Date;

/**
 * User: FIRE
 * Date: 2018/9/9
 * Description:
 */
public class Main {
    public static void main(String[] args){
        int[] arr=creatArr(200,12,2000);
       int[] copyArr=deepCopy(arr,0,arr.length-1);
//        int[] copyArr1=deepCopy(arr,0,arr.length-1);
//        QuickSort.sort(arr,0,arr.length-1);
//        printArr(arr);
//        BubbleSort.sort(copyArr);
//        printArr(copyArr);
//        SelectSort.sort(copyArr1);
//        printArr(copyArr1);
//        long start=new Date().getTime();
//        ShellSort.sort(copyArr);
//        long end=new Date().getTime();
//        System.out.println(end-start);
//        end=new Date().getTime();
//        MergeSort.sort(arr);
//        long start1=new Date().getTime();
//        System.out.println(start1-end);
//        isOrder(arr);printArr(arr);
        SelectSort.sortSimple(arr);
        printArr(arr);

    }










    public static void printArr(int[] arr){
        int len=arr.length;
        for (int i=0;i<len;i++)
            System.out.print(arr[i]+"  ");
        System.out.println();
    }
    public  static int[]  creatArr(int len,int mix,int max){
        int[] arr=new int [len];
        double p;
         for (int i=0;i<len;i++){
             p=Math.random();
             arr[i]= (int) (p*max+(1-p)*mix);
         }
        return arr;
    }
    public static int[]  deepCopy(int[] arr,int s,int e){
        int len=e-s+1;
        int [] copy=new int[len];
        for (int i=0;i<len;i++)
            copy[i]=arr[s++];
        return copy;
    }
    public static boolean  isOrder(int arr[]){
        boolean is=true;
        for (int i=0;i<arr.length-1;i++){
            if (arr[i]>arr[i+1])
                is=false; }
        if (is)
            System.out.println("is order");
        else
            System.out.println("not order");
        return is;
    }

}