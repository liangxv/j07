package com.noniuxy.p2;

import java.util.Scanner;

public class AppDemo9 {
    public static void main(String[] args) {
        int prev1 = 0, prev2 = 1;
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入斐波那契数列的前n项: ");
        int n = scanner.nextInt();
        int[] fibonacciSequence = new int[n];

        // 前两项已知
        fibonacciSequence[0] = prev1;

        if (n == 1) {
            System.out.println("斐波那契数列的第1项结果是 " + prev1);
            return;
        }

        fibonacciSequence[1] = prev2;

        // 计算斐波那契数列的第3项到第n项
        for (int i = 2; i < n; i++) {
            fibonacciSequence[i] = fibonacciSequence[i - 1] + fibonacciSequence[i - 2];
        }

        // 输出斐波那契数列的第n项结果
        System.out.println("斐波那契数列的第" + n + "项结果是 " + fibonacciSequence[n - 1]);
    }
}
