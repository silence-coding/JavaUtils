package com.kangtian.util.heap;

/**
*堆是一组元素按照完全二叉树的形式存储在一个数组里面，并且在这个完全二叉树里面满足父节点和子节点的关系为
 * Ki <= K2*i+1 且 Ki<= K2*i+2(或Ki >= K2*i+1 且 Ki >= K2*i+2) i = 0，1，2…， 的一种数据结构。
 */
public  class Heap {
    int size=0,len=16;double capacity=1.5;
    int [] heap;
    public Heap(){
        heap=new int[len];
    }
    public Heap(int len){
        this.len=len;
        heap=new int[len];
    }
    public Heap(int len,int capacity){
        this.len=len;
        this.capacity=capacity;
        heap=new int[len];
    }
    public int peek(){
        return heap[0];
    }
    public void printHeap(){
        for (int i=0;i<size;i++)
            System.out.print(heap[i]+" , ");
        System.out.println();
    }
    public static void swap(int arr[],int a,int b){
        int tem=arr[a];
        arr[a]=arr[b];
        arr[b]=tem;
    }
    public int pop(){
        int tem=heap[0];
        heap[0]=heap[size-1];
        size--;
        adjust(heap,size-1);
        return size;
    }
    public  void adjust(int heap[] ,int end){

    }

    public  boolean isEmpty(){
        return size==0;
    }
    public  boolean isFull(){
        return size==len;
    }
    public static boolean isHeap( int[] arr){
        boolean is=true;
        int len=arr.length-1;
        if (len<=1)
            return is;
        if (arr[0]<arr[1])
        for(int i=(len-1)/2;i>=0;i--){
            int k=i;//k对应树的根节点
            while(k*2+1<=len){
                int j=2*k+1;//对应子节点
                    if(j<len&&arr[j]>arr[j+1])
                        j++;
                if(arr[k]>arr[j]){//判断根节点是否大于子节点，如果是，则不满足小堆
                  is=false;i=-1;
                    break;
                }
                else {
                    k=j;
                }
            }
        }
        else
            for(int i=(len-1)/2;i>=0;i--){
                int k=i;
                while(k*2+1<=len){
                    int j=2*k+1;
                    if(j<len&&arr[j]>arr[j+1])
                        j++;
                    if(arr[k]<arr[j]){//判断根节点是否小于父节点，如果是，则不满足大堆
                        is=false;i=-1;
                        break;
                    }else{
                       k=j;
                    }
                }
            }
        return is;
    }
}
