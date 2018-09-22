package com.kangtian.util.sort;

/**
 * User: FIRE
 * Date: 2018/9/15
 * Description:
 */
public class ShellSort {
    /**希尔排序的原理:根据需求，如果你想要结果从大到小排列，它会首先将数组进行分组，然后将较大值移到前面，较小值
     * 移到后面，最后将整个数组进行插入排序，这样比起一开始就用插入排序减少了数据交换和移动的次数，可以说希尔排序是加强
     * 版的插入排序
     * 拿数组5, 2, 8, 9, 1, 3，4来说，数组长度为7，当increment为3时，数组分为两个序列
     * 5，2，8和9，1，3，4，第一次排序，9和5比较，1和2比较，3和8比较，4和比其下标值小increment的数组值相比较
     * 此例子是按照从大到小排列，所以大的会排在前面，第一次排序后数组为9, 2, 8, 5, 1, 3，4
     * 第一次后increment的值变为3/2=1,此时对数组进行插入排序，
     *实现数组从大到小排
     */

    public static void shellSort(int[] data)
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
                    if(temp > data[j - increment])//如想从小到大排只需修改这里
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
}package com.kangtian.util.sort;


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
