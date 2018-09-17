package com.kangtian.util.heap;

import com.kangtian.util.sort.Main;

public class MinHeap extends Heap {
    public MinHeap(){
        heap=new int[len];
    }
    public MinHeap(int len){
        this.len=len;
        heap=new int[len];
    }
    public MinHeap(int len,int capacity){
        this.len=len;
        this.capacity=capacity;
        heap=new int[len];
    }
    public MinHeap(int [] arr){
        len=arr.length;
        heap=new int[len];
        for (int i=0;i<len;i++) {
                insert(arr[i]);
        }
    }
    public void insert(int num)  {
        if (isFull()){
            len=(int) (len*capacity);
            int tem[] =new int[len];
            for (int i=0;i<size;i++)
                tem[i]=heap[i];
            heap=tem;
        }
        int i = size;//指向插入元素后堆中的最后一个元素的位置
        for(;i>0 && heap[(i-1)/2]>num;i=(i-1)/2){
            heap[i] = heap[(i-1)/2];
        }
        heap[i] = num;
        size++;
    }
    public  void adjust(int heap[] ,int end){
        for(int i=(end-1)/2;i>=0;i--){
            int k=i;
            while(k*2+1<=end){
                int j=2*k+1;
                if(j<end){
                    if(heap[j]>heap[j+1]){
                        j++;
                    }
                }
                if(heap[k]>heap[j]){
                    swap(heap,k,j);
                    k=j;
                }else{
                    break;
                }
            }
        }
    }
    public void sort(){
        sort(heap);
    }
    public  void sort(int arr[]){
        int len=arr.length;
        for (int i=0;i<len;i++) {
            adjust(arr, len - 1 - i);
            swap(arr, 0, len - i - 1);
        }
        int i=0,end=arr.length-1;
        while (i<end){
            swap(arr,i,end);
            i++;end--;
        }

    }
    public static void main(String[] args){
        int [] arr= {5,6,8,9,7 ,7,15,17};
       MaxHeap h = new MaxHeap(arr);
       System.out.println(isHeap(h.heap));
    }
}
