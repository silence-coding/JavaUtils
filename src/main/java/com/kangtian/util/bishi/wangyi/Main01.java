package com.kangtian.util.bishi.wangyi;



/**
 * User: FIRE
 * Date: 2018/9/15
 * Description:
 */


import java.util.Scanner;

public class Main01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

            String a = in.nextLine();
            String b = in.nextLine();
            System.out.println(count(a,b));
    }
    public static int count(String a,String b){
        int result=0;
        char[] arr1 = a.toCharArray();
        StringBuffer tem=new StringBuffer(b);
        for (int i=0;i<arr1.length;i++){
            if (i>=tem.length()){
                result+=arr1.length-i;
                break;
            }
              else {
                if (arr1[i] == tem.charAt(i))
                    continue;
                else {
                    if (i==arr1.length-1||i==tem.length()-1) {
                        tem.setCharAt(i, arr1[i]);
                        result += 2;
                        break;
                    }
                    if (arr1[i + 1] == tem.charAt(i + 1)) {
                        tem.setCharAt(i, arr1[i]);
                        result += 2;
                    } else if (arr1[i + 1] == tem.charAt(i) & arr1[i + 1] != tem.charAt(i + 1)) {
                        tem.insert(i, arr1[i]);
                        result++;
                    }
                }
            }

        }
        if (tem.length()>arr1.length)
            result+=tem.length()-arr1.length;
        return result;
    }
}