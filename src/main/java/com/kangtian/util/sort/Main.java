package com.kangtian.util.sort;

/**
 * User: FIRE
 * Date: 2018/9/9
 * Description:
 */
public class Main {
    public static void main(String[] args){
        int[] arr=creatArr(20,12,180);
        int[] copyArr=deepCopy(arr,0,arr.length-1);
        int[] copyArr1=deepCopy(arr,0,arr.length-1);
        QuickSort.sort(arr,0,arr.length-1);
        printArr(arr);
        BubbleSort.sort(copyArr);
        printArr(copyArr);

        SelectSort.sort(copyArr1);
        printArr(copyArr1);
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

}