package com.woniuxy.view;

import com.woniuxy.utils.LoginStatus;

import java.util.Scanner;

public class WelcomeView {
    static Scanner scanner = new Scanner(System.in);

    private static void menu() {
        System.out.println("按1.登陆系统");
        System.out.println("按2.注册用户");
        System.out.println("按0.结束");
        System.out.println("请输入您的选择：");
    }

    public static void operate() {
        while (true) {
            menu();
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    LoginStatus.current = CommonView.login();
                    return;
                case 2:
                    UserView.userRegistration();
                    break;
                case 0:
                    System.exit(1);
                default:
                    System.out.println("输入有误！");
            }
        }

    }


}
