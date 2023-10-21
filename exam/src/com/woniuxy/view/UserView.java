package com.woniuxy.view;

import com.woniuxy.dao.impl.UserDaoImpl;
import com.woniuxy.dao.UserDao;
import com.woniuxy.pojo.User;

import java.util.Scanner;

public class UserView {
    private static final Scanner scanner = new Scanner(System.in);
    static UserDao userDao = new UserDaoImpl();

    private static void menu() {
        System.out.println("------------- 用户管理 -------------");
        System.out.println("按1.注册用户");
        System.out.println("请输入您的选择：");
    }

    public static void operate() {
        menu();
        //选择
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                userRegistration();
                break;
            case 10:
                return;
        }
    }

    private static void userRegistration() {
        System.out.println("输入用户名");
        String name = scanner.next();
        System.out.println("输入密码");
        String password = scanner.next();
        User user = new User(null,name,password);
        Integer row = userDao.userRegistration(user);
        if (row>0){
            System.out.println("注册成功");
        }
    }
}
