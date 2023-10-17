package com.woniuxy.pojo;

import java.util.Scanner;

public class AppDemo {
    public static void main(String[] args) {
        System.out.println("输入一个数字 ");
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        if (isDoud(i)) {
            System.out.println("是偶数 " );
        }else {
            System.out.print("不是偶数");
        }
    }

    public static boolean isDoud(int i) {
        return i % 2 == 0;
    }
}
