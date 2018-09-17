package com.kangtian.util.sort;

import com.kangtian.util.heap.MaxHeap;

import java.util.Arrays;

public class HeapSort {
    private static MaxHeap maxHeap=new MaxHeap();
    public static void main(String[] args) {
        int[] a={46,79,56,38,40,84};
        sort(a);
            System.out.println(Arrays.toString(a));
    }
   public static void sort(int[] arr){
            maxHeap.sort(arr);
   }

}