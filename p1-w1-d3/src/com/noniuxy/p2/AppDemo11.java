package com.noniuxy.p2;

import java.util.Scanner;

public class AppDemo11 {
    public static void main(String[] args) {
        System.out.print("请输入要存多少钱：");
        Scanner scanner = new Scanner(System.in);
        int targetAmount = scanner.nextInt(); // 输入的目标存款金额
        int day = 1; // 存款的天数
        int savedAmount = 0; // 已存的金额

        // 循环计算存款天数，直到达到或超过目标金额
        while (true) {
            savedAmount += day; // 当天存入的金额累加到总金额中
            if (savedAmount >= targetAmount) {
                System.out.println("需要存 " + day + " 天才能满足目标，预计存款总额为 " + savedAmount + " 元");
                break; // 达到目标金额，退出循环
            }
            day++; // 增加存款天数
        }
    }
}
