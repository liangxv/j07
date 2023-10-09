package com.noniuxy.p2;

import java.util.Scanner;

public class AppDemo7 {
    public static void main(String[] args) {
        // 定义票价
        double price = 300;
        double upgradedPrice = 500;

        // 提示用户输入月份和座位类型
        System.out.print("请输入月份的值:");
        Scanner scanner = new Scanner(System.in);
        int month = scanner.nextInt();
        System.out.print("请输入座位类型（头等舱，经济舱）:");
        String type = scanner.next();

        // 根据月份和座位类型计算价格
        if (month >= 5 && month <= 10) {
            if (type.equals("头等舱")) {
                upgradedPrice *= 0.9; // 旅游旺季头等舱打9折
                System.out.println("旅游旺季" + type + "打9折需要支付" + price + "元");
            } else {
                price *= 0.85; // 旅游旺季经济舱打8.5折
                System.out.println("旅游旺季" + type + "打8.5折" + price + "元");
            }
        } else {
            if (type.equals("头等舱")) {
                upgradedPrice *= 0.7; // 旅游淡季头等舱打7折
                System.out.println("旅游淡季" + type + "打7折" + price + "元");
            } else {
                price *= 0.65; // 旅游淡季经济舱打6.5折
                System.out.println("旅游淡季" + type + "打6.5折" + price + "元");
            }
        }
    }
}
