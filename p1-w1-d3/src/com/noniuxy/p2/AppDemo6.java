package com.noniuxy.p2;

import java.util.Random;
import java.util.Scanner;

public class AppDemo6 {
    public static void main(String[] args) {
        // 创建一个随机数生成器
        Random random = new Random();
        // 生成一个随机数，范围在1到100之间
        int targetNumber = random.nextInt(100)+1;

        // 创建一个用于接收用户输入的Scanner对象
        Scanner scanner = new Scanner(System.in);

        // 提示用户输入猜测的数字
        System.out.print("请输入猜测的数字:");

        // 读取用户输入的整数
        int userGuess = scanner.nextInt();
        int guessCount = 1; // 计数猜测次数的变量，初始值为1

        while (true) {
            if (userGuess == targetNumber) {
                System.out.println("猜对了");
                break; // 如果猜对了，退出循环
            } else if (userGuess > targetNumber) {
                System.out.println("过大");
            } else {
                System.out.println("过小");
            }

            // 提示用户再次输入猜测的数字
            System.out.print("请输入猜测的数字:");
            userGuess = scanner.nextInt(); // 读取用户的下一个猜测
            guessCount++; // 增加猜测次数
        }

        // 打印猜测的总次数
        System.out.println("总共猜测了" + guessCount + "次");
    }
}
