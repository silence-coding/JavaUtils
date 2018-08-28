package com.kangtian.util.string;

import java.util.Scanner;

 class Node{
    int x;
    int y;
    boolean sended;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
        this.sended = false;
    }

    public int getLength(Node p){
        return Math.abs(x - p.x) + Math.abs(y - p.y);
    }
}

public class Main {
    static final Node START = new Node(0,0);
    static int min = Integer.MAX_VALUE;

    public static int calculate(Node Node,Node[] Nodes,int sum,int count){
        for(int i=0;i<Nodes.length;i++){
            if(Nodes[i].sended==false){
                Nodes[i].sended=true;
                count++;
                sum +=Node.getLength(Nodes[i]);
                if(count==Nodes.length){
                    sum+=Nodes[i].getLength(START);
                    if(sum<min){
                        min = sum;
                    }
                }
                calculate(Nodes[i],Nodes,sum,count);
                Nodes[i].sended=false;
                sum-=Node.getLength(Nodes[i]);
                count--;
            }
        }
        return min;
    }



    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String read = scan.nextLine();
        int num=Integer.parseInt(read);
        Node[] Nodes = new Node[num];
      for (int i=0;i<num;i++){
           read = scan.nextLine();
           String[] lis=read.split(",");
           Nodes[i] = new Node(Integer.parseInt(lis[0]), Integer.parseInt(lis[1]));
       }
        int min = calculate(START, Nodes, 0, 0);
        System.out.println(min);
    }
}
