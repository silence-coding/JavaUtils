package com.kangtian.util.sort;

/**
 * User: FIRE
 * Date: 2018/9/9
 * Description:  O(n2)
 */
public class BubbleSort {
    public static void sort(int [] arr){
        int len=arr.length;
        int tem,count=1;//初始化值为1，确保第一次能进入循环
        for (int i=0;i<len-1;i++) {
            if (count > 0) {//count大于0，说明上次轮循出现了交换，即序列可能是处于无序状态的
                count=0;//赋值为零，进行下一次冒泡，并统计交换次数用于判断数组是否有序
                for (int j = 0; j < len - i - 1; j++) {
                    //通过不断的比较arr j j+1处位置大小， 把大的数往后挪，
                    // 每次都能保证将len-i个里的最大的挪到数组len-i处
                    //如1 4 2 3 5 2  第一次，4和2换，4和3换 5和最后一个2换 。得1 2 3 4 2 5
                    if (arr[j] > arr[j + 1]) {
                        count++;
                        tem = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = tem;
                    }
                }
            }else {
                break;//数组已经有序，跳出循环
            }
        }
    }

}