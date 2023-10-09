package com.noniuxy.p3;

import java.util.Scanner;
import java.util.Random;

public class AppDemo1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("请输入你上班一共要经过几个红绿灯：");
        int n = scanner.nextInt();

        int totalWaitTime = 0; // 总等待时间

        for (int i = 1; i <= n; i++) {
            int lightStatus = random.nextInt(2); // 生成0或1，表示红绿灯状态

            if (lightStatus == 1) {
                int waitTime = random.nextInt(100) + 1; // 生成1-100秒的等待时间
                System.out.println("第 " + i + " 个红绿灯为红灯，等待时间为 " + waitTime + " 秒");
                totalWaitTime += waitTime;
            } else {
                System.out.println("第 " + i + " 个红绿灯为绿灯，可通过");
            }
        }

        System.out.println("你上班路上的红绿灯总等待时间为 " + totalWaitTime + " 秒");
    }
}
