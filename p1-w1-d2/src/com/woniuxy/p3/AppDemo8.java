package com.woniuxy.p3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AppDemo8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = getInput("输入一个数:", scanner);
        if (n <= 1) {
            System.out.println("不是素数");
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                System.out.println(n + "不是素数");
                return;
            }
        }
        System.out.println(n + "是素数");
    }

    private static int getInput(String prompt, Scanner scanner) {
        int input = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print(prompt);
                input = scanner.nextInt();
                if (input < 0) {
                    System.out.println("请输入有效的非整负数！");
                    continue;
                }
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("请输入有效的数值！");
                scanner.nextLine();
            }
        }

        return input;
    }
}
