package com.woniuxy.p1;

import java.util.Scanner;

public class AppDemo5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入价格:");
        int i = scanner.nextInt();
        String rous = i>=200?"原始价格"+i+"\n最终支付价格"+i*0.9:"原始价格"+i+"最终支付价格"+i*1.0;

        System.out.println(rous);
    }
}
