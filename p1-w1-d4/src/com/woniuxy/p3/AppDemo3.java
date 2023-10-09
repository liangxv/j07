package com.woniuxy.p3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class AppDemo3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入裁判的人数");
        int count = scanner.nextInt();
        int[] nums = randomInt(count);
        System.out.println(count + "位裁判给出的成绩 " + Arrays.toString(nums));
        double finalScore = calculateFinalGrade(nums);
        System.out.println("最终成绩为： " + finalScore);
    }

    // 计算去掉一个最高分和一个最低分后的平均值
    public static double calculateFinalGrade(int[] scores) {
        int sum = calculateSum(scores);
        int max = findMax(scores);
        int min = findMin(scores);
        int count = scores.length;

        // 计算去掉一个最高分和一个最低分后的总和
        int adjustedSum = sum - max - min;

        // 计算平均值

        return (double) adjustedSum / (count - 2);
    }

    // 生成指定数量的随机整数
    public static int[] randomInt(int count) {
        Random random = new Random();
        int[] ints = new int[count];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = random.nextInt(100) + 1;
        }
        return ints;
    }

    // 计算整数数组的总和
    public static int calculateSum(int[] numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }

    // 找到整数数组中的最大值
    public static int findMax(int[] numbers) {
        int max = numbers[0];
        for (int num : numbers) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    // 找到整数数组中的最小值
    public static int findMin(int[] numbers) {
        int min = numbers[0];
        for (int num : numbers) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }
}
