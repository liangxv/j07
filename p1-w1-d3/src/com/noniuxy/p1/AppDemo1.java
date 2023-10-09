package com.noniuxy.p1;

import java.util.Scanner;

public class AppDemo1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入咖啡类型的数字");
        String id = scanner.next();
        switch (id){
            case "1":
                System.out.println("您选择了美式咖啡,价格为$2.50");
                break;
            case "2":
                System.out.println("您选择了拿铁咖啡");
                break;
            case "3":
                System.out.println("您选择了摩卡咖啡");
                break;
            case "4":
                System.out.println("您选择了卡布奇诺咖啡");
                break;
            default:
                System.out.println("输入数字无效");
                break;
        }

    }
}
