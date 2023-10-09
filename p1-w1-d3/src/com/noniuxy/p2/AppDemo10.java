package com.noniuxy.p2;

public class AppDemo10 {
    public static void main(String[] args) {
        for (int i = 100; i <= 999; i++) {
            int sum = 0;
            int num = i;

            // 提取每一位数字，计算立方和
            while (num > 0) {
                int digit = num % 10; // 获取最低位的数字
                sum += Math.pow(digit, 3); // 计算当前位的立方和
                num /= 10; // 移除已处理的最低位
            }

            // 判断是否为水仙花数并输出
            if (sum == i) {
                System.out.println(i + " 是水仙花数");
            }
        }
    }
}
