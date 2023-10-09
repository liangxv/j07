package com.noniuxy.p1;

import java.util.Scanner;

public class AppDemo5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入乘法表的行数和列数（例如：9）：");
        int rows = scanner.nextInt();

        // 外层循环控制行数
        for (int i = 1; i <= rows; i++) {
            // 内层循环控制列数
            for (int j = 1; j <= i; j++) {
                int product = i * j; // 计算乘法结果
                // 输出乘法表达式和结果，使用制表符分隔
                System.out.print(i + "x" + j + "=" + product + "\t");
            }
            System.out.println(); // 换行，进入下一行的循环
        }
    }
}
