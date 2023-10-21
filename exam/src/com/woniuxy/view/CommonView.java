package com.woniuxy.view;



import com.woniuxy.dao.impl.UserDaoImpl;
import com.woniuxy.dao.UserDao;
import com.woniuxy.pojo.User;

import java.util.Scanner;

public class CommonView {
    static UserDao userDao =new UserDaoImpl();
    private static final Scanner scanner =new Scanner(System.in);

    public static void menu() {
        System.out.println("-------------欢迎进入CRM系统-------------");
        System.out.println("按1.进入用户管理");
        System.out.println("按2.进入联系人管理");
        System.out.println("按0,退出系统");
        System.out.println("请输入您的选择：");
    }
    public static User login(){
        System.out.println("-- 登录CRM系统 --");
        System.out.println("请输入登录名：");
        String loginName = scanner.next();
        System.out.println("请输入密码：");
        String password = scanner.next();

        User user = userDao.login(loginName,password);
        if (user==null) {
            System.out.println("登陆失败,用户名或密码错误,请重新登陆");
            return login();
        }
        System.out.println("登陆成功");
        return user;
    }
}
