package com.kangtian.util.test.tentcent;

/**
 * User: FIRE
 * Date: 2018/9/16
 * Description:
 */

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Set<Integer>[] arr=new Set[n+1];
        int[][] arr1=new int[n+1][2];
        for(int i = 0; i < m; i++){
           arr[sc.nextInt()].add(sc.nextInt());
        }
        int tem;
   for (int i=1;i<n+1;i++){
       if (arr[i].size()>0) {
           Iterator item = arr[i].iterator();
           while (item.hasNext()) {
               tem = (Integer) item.next();
               if (tem != i) {
                   arr1[i][0] += 1;
                   arr1[tem][1] += 1;
               }
           }
       }
       }
        System.out.println(count(arr1));
    }
    public static int count(int [][]arr){
        int count=0;
        for (int i=1;i<arr.length;i++){
            if (arr[i][0]<arr[i][1]) {
                count++;
            }
        }
        return count;
    }
}