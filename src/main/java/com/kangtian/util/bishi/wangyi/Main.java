package com.kangtian.util.bishi.wangyi;



/**
 * User: FIRE
 * Date: 2018/9/15
 * Description:
 */


import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
           int[][] arr=new int[4][2];
           for (int i=0;i<4;i++){
               arr[i][0]= in.nextInt();
               arr[i][1]= in.nextInt();
           }
    }
    public static void count(int[][] arr){
        int count;
        int [] tem=getLenPow(arr);
        if (tem[0]+tem[1]<tem[3]){
            count=2;
        }
        else {
            count=4;
        }
        findMax(arr,count);
        System.out.println(count);
    }
    public static void findMax(int [] [] arr,int count){
        int max=0;



        System.out.println(max);
    }






    public static int[]  getLenPow(int[][] arr){
        int [] tem=new int[3];
        int atem=  arr[0][0]-arr[1][0];
        int btem=  arr[0][1]-arr[1][1];
        tem[0]=atem*atem+btem*btem;;
         atem=  arr[0][0]-arr[2][0];
         btem=  arr[0][1]-arr[2][1];
        tem[1]=atem*atem+btem*btem;
         atem=  arr[1][0]-arr[2][0];
         btem=  arr[1][1]-arr[2][1];
       tem[2]=atem*atem+btem*btem;
        sort(tem);
        return tem;
    }
    public static void sort(int [] arr){
        int len=arr.length;
        int tem=0;
        for (int i=0;i<len-1;i++){
            int p=i;
            for (int j=len-1;j>i;j--){
                if (arr[j]<arr[p])
                    p=j;
            }
            tem=arr[p];
            arr[p]=arr[i];
            arr[i]=tem;
        }
    }

}