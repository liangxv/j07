package com.woniu;

import com.woniu.utils.LoginStatus;
import com.woniu.view.CommonView;
import com.woniu.view.CustomerView;

import java.util.Scanner;

public class CrmApplication {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        LoginStatus.current = CommonView.login();
        while (true) {
            //显示菜单
            CommonView.menu();
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    //调用员工管理模块
                    System.out.println("调用员工管理模块");
                    break;
                case 2:
                    //调用客户管理模块
                    CustomerView.operate();
                    break;
                case 3:
                    //调用产品管理模块
                    System.out.println("调用产品管理模块");
                    break;
                case 0:
                    return;
                default:
                    System.out.println("输入有误！");
            }

        }
    }
}
