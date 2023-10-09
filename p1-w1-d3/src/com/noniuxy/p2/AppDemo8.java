package com.noniuxy.p2;

import java.util.Scanner;

public class AppDemo8 {
    public static void main(String[] args) {
        // 提示用户输入班级人数
        System.out.print("请输入班级人数: ");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        // 创建一个数组来存储成绩
        double[] classGrades = new double[num];

        double sum = 0.0;
        int pass = 0;
        int unpass = 0;
        double max = 0.0;
        double min = 100.0; // 假设成绩最低是100分，确保能找到更低的分数

        // 循环输入每个同学的成绩
        for (int i = 0; i < num; i++) {
            System.out.print("输入第" + (i + 1) + "位同学的成绩: ");
            classGrades[i] = scanner.nextDouble();

            // 统计及格和不及格人数
            if (classGrades[i] >= 60) {
                pass++;
            } else {
                unpass++;
            }

            // 查找最高分和最低分
            if (classGrades[i] > max) {
                max = classGrades[i];
            }
            if (classGrades[i] < min) {
                min = classGrades[i];
            }

            sum += classGrades[i];
        }

        double average = sum / num;

        // 输出结果
        System.out.println("平均成绩: " + average);
        System.out.println("及格人数: " + pass);
        System.out.println("不及格人数: " + unpass);
        System.out.println("最高分: " + max + " 最低分: " + min);
    }
}
