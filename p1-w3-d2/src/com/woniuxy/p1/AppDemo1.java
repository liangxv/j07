package com.woniuxy.p1;

import java.util.Scanner;

public class AppDemo1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isEx = true;

        do {
            try {
                System.out.println("请输入商品数量:");
                int quantity = scanner.nextInt();
                if (quantity<0) {
                    throw new IllegalArgumentException("商品数量不能为负数");
                } else {
                    isEx =false;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("重新输入");
            }
        } while (isEx);
    }
}
