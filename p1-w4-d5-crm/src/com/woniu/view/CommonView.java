package com.woniu.view;

import com.woniu.dao.EmployeeDao;
import com.woniu.dao.impl.EmployeeDaoImpl;
import com.woniu.pojo.Employee;

import java.util.Scanner;

public class CommonView {
    static EmployeeDao employeeDao = new EmployeeDaoImpl();
    private static Scanner scanner =new Scanner(System.in);

    public static void menu() {
        System.out.println("-------------欢迎进入CRM系统-------------");
        System.out.println("按1.进入员工管理");
        System.out.println("按2.进入客户管理");
        System.out.println("按3.进入产品管理");
        System.out.println("按0,退出系统");
        System.out.println("请输入您的选择：");
    }
    public static Employee login(){
        System.out.println("-- 登录CRM系统 --");
        System.out.println("请输入登录名：");
        String loginName = scanner.next();
        System.out.println("请输入密码：");
        String password = scanner.next();

        Employee employee = employeeDao.login(loginName,password);
        if (employee==null) {
            System.out.println("登陆失败,用户名或密码错误,请重新登陆");
            return login();
        }
        System.out.println("登陆成功");
        return employee;
    }
}
