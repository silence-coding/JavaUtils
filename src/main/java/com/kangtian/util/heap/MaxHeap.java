package com.kangtian.util.heap;


public class MaxHeap extends Heap {
    public MaxHeap(){
        heap=new int[len];
    }
    public MaxHeap(int len){
        this.len=len;
        heap=new int[len];
    }
    public MaxHeap(int len,int capacity){
        this.len=len;
        this.capacity=capacity;
        heap=new int[len];
    }
    public MaxHeap(int [] arr){
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
        for(;i>0 && heap[(i-1)/2]<num;i=(i-1)/2){
            heap[i] = heap[(i-1)/2];
        }
        heap[i] = num;
        size++;
    }

    //调整数组，使其保持堆的性质
    @Override
    public  void adjust(int heap[] ,int end){
        for(int i=(end-1)/2;i>=0;i--){
            int k=i;//根节点
            while(k*2+1<=end){
                int j=2*k+1;
                if(j<end){
                    if(heap[j]<heap[j+1]){
                        j++;
                    }
                }
                if(heap[k]<heap[j]){//判断
                    swap(heap,k,j);
                    k=j;
                }else{
                    break;
                }
            }
        }
    }
    public  void sort(int arr[]){
        int len=arr.length;
        for (int i=0;i<len;i++) {
            adjust(arr, len - 1 - i);
            swap(arr, 0, len - i - 1);
        }
    }
}
