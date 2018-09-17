package com.kangtian.util.sort;


/**
 * 高效
 */
public class ShellSort {
    /**希尔排序的原理:
     * 将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，
     * 待整个序列中的记录“基本有序”时，再对全体记录进行依次直接插入排序。
     */

    public static void sort(int[] data)
    {
        int j = 0;
        int temp = 0;
        //每次将步长缩短为原来的一半
        for (int increment = data.length / 2; increment > 0; increment /= 2)
        {
            for (int i = increment; i < data.length; i++)
            {
                temp = data[i];
                for (j = i; j >= increment; j -= increment)
                {
                    if(temp <data[j - increment])//如想从小到大排只需修改这里
                    {
                        data[j] = data[j - increment];
                    }
                    else
                    {
                        break;
                    }

                }
                data[j] = temp;
            }

        }
    }
}
