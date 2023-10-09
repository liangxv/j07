package com.wonuixy;

import java.util.Scanner;

public class AppDemo5 {
    public static void main(String[] args) {
        System.out.print("请输入你的体重（千克）:");
        Scanner scanner = new Scanner(System.in);
        double weight = scanner.nextDouble();
        System.out.print("请输入你的身高（米）:");
        double height = scanner.nextDouble();
        //计算收缩压
        double sbl = 110 + 1.6 * (height - 1.5) * 10 + 0.1 * (weight);
        //计算舒张压
        double dbl = 70 + 1.2 * (height - 1.5) * 10 + 0.15 * (weight);
        System.out.println("收缩压为:" + sbl);
        System.out.println("舒张压为:" + dbl);

    }
}
