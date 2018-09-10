package com.kangtian.util.array;

/**
 * User: FIRE
 * Date: 2018/9/9
 * Description:
 */
// 本题为考试多行输入输出规范示例，无需提交，不计分。
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] [] arr=new int[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                arr[i][j] = sc.nextInt();
        if (n==0)
            System.out.println(0);
            else
        System.out.println(find(arr,n));

    }
    public static int find(int[][] arr,int len){
        int result=0;
        for (int i=0;i<len;i++)
            for (int j=0;j<len;j++){
               if (findHasNext(arr,i,j,len))
                   result++;
            }
        return result;
    }

    public static boolean findHasNext(int[][] arr, int i,int j,int len) {
        if (i<len&j<len)
        if (arr[i][j]!=0){
            arr[i][j]=0;
            int temi=i,temj=j;
            findHasNext(arr, i, j++, len);
            findHasNext(arr, i++, j, len);
            if (temi<len&temj<len){
                findHasNext(arr, temi++, temj, len);
                findHasNext(arr, temi, temj++, len);
            }
        }else {
            return false;
        }
        else {
            return false;
        }
        return true;
    }
}