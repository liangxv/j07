package com.woniuxy.p3;

import java.util.Scanner;

public class AppDemo6 {
    public static void main(String[] args) {
        System.out.print("输入用户名：");
        Scanner scanner =new Scanner(System.in);
        String user = scanner.next();
        System.out.print("输入密码：");
        String passwd = scanner.next();
        String User = "newboy";
        String Passwd = "newboy";
        if (user.equals(User)&&passwd.equals(Passwd)){
            System.out.println("登录成功");
        }else {
            System.out.println("登录失败");
        }
    }
}
