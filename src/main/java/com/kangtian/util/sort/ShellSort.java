package com.kangtian.util.sort;


/**
 * 高效
 */
public class ShellSort {
    /**希尔排序的原理:
     * 将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，
     * 待整个序列中的记录“基本有序”时，再对全体记录进行依次直接插入排序。
     */

    public static void sort(int[] data) {
        int j = 0;
        int temp = 0;
        for (int inc = data.length / 2; inc > 0; inc /= 2)//每次讲增量变为原来一半
            for (int i = inc; i < data.length; i++) {//对每个小序列进行插入排序，当inc变为1时，对整体进行插入排序
                temp = data[i];
                for (j = i; j >= inc&&temp <data[j - inc]; j -= inc) {//查找插入位置i
                    data[j] = data[j - inc];//将元素后挪
                }
                    data[j] = temp; //交换值
            }
    }
}
