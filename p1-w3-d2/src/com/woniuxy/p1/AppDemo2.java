package com.woniuxy.p1;

import java.util.Scanner;

public class AppDemo2 {
    static int balance =10000;
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        System.out.println("请输入要取多少钱");
        int i =scanner.nextInt();
        try {
            del(i);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("[操作取钱]"+i+"元");
        }

    }
    private  static  void del(int i)throws IllegalArgumentException{
        balance=balance-i;
        if (balance<0) {
            throw new IllegalArgumentException("余额不足");
        } else {
            System.out.println("取钱:"+i+"余额:"+balance);
        }
    }
}
