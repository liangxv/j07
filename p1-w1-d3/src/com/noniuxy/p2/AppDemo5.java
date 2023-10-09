package com.noniuxy.p2;

public class AppDemo5 {
    public static void main(String[] args) {
        int[] arr = {800, 650, 1200, 900, 1500, 300, 770, 1100};

        // 遍历输出所有成员
        System.out.println("所有成员:");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        System.out.println("------------------------------------");

        // 遍历输出所有1000以上的成员
        System.out.println("所有1000以上的成员:");
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] > 1000) {
                System.out.println(arr[j]);
            }
        }

        System.out.println("------------------------------------");

        // 计算1000以下的成员有多少个?
        // 计算1000以下的成员的累加总和是多少?
        // 将1000以上的成员拼成一个字符串str, 格式示例: 1200-1500-1100-
        int count = 0;
        int sum = 0;
        String longstr = "";
        for (int f = 0; f < arr.length; f++) {
            if (arr[f] < 1000) {
                count++;
                sum += arr[f];
            } else {
                longstr += arr[f] + "-";
            }
        }
        System.out.println("1000以下的成员个数: " + count);
        System.out.println("1000以下的成员累加总和: " + sum);
        System.out.println("1000以上的成员拼接字符串: " + longstr);

        System.out.println("------------------------------------");
    }
}
