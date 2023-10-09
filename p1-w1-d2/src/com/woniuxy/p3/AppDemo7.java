package com.woniuxy.p3;

import java.util.Scanner;

public class AppDemo7 {
    public static void main(String[] args) {
        System.out.print("输入菜品数：");
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        double sum = 0.0;
        double discount = 1.0;
        if (count > 10) {
            discount *= 0.7;
            sum = 10 * count * discount;
        } else if (count > 7) {
            discount *= 0.8;
            sum = 10 * count * discount;
        } else if (count > 4) {
            discount *= 0.9;
            sum = 10 * count * discount;
        } else {
            sum = 10 * count * 1.0;
        }
        System.out.println("打"+(discount*10)+"折"+"需要支付" + sum + "元费用");
    }
}
