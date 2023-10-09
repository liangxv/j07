package com.woniuxy.p2;

import java.util.Scanner;

public class AppDemo1 {

    static String[] companies = {"阿里巴巴-1999", "华为-1987", "中兴-1985", "腾讯-1998", "京东-1998", "谷歌-1998", "微软-1975", "亚马逊-1994"};
    static Enterprise enterprise = new Enterprise(companies);

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        displayMenu();
        while (true) {
            int opthin = Integer.parseInt(getInput("选择功能:", scanner));
            switch (opthin) {
                case 1:
                    enterprise.listAllEnterprises();
                    break;
                case 2:
                    String enterprisename = getInput("请输入企业的关键字：", scanner);
                    enterprise.findEnterpriseByName(enterprisename);
                    break;
                case 3:
                    String keyword = getInput("请输入企业的关键字：", scanner);
                    enterprise.countEnterprisesByName(keyword);
                    break;
                case 4:
                    int low = Integer.parseInt(getInput("请输入开始时间（yyyy）：", scanner));
                    int high = Integer.parseInt(getInput("请输入结束时间（yyyy）：", scanner));
                    enterprise.findEnterprisesByTimeRange(low, high);
                    break;
                case 5:
                    String enterpriseName = getInput("请输入企业名称：", scanner);
                    String establishedTime = getInput("请输入成立时间（yyyy）：", scanner);
                    enterprise.addEnterprise(enterpriseName, establishedTime);
                    break;
                case 6:
                    enterprise.listAllEnterprises();
                    int index = Integer.parseInt(getInput("请输入索引：", scanner));
                    String updaeEnterpriseName = getInput("请输入企业名称：", scanner);
                    String updateEstablishedTime = getInput("请输入成立时间（yyyy）：", scanner);
                    enterprise.updateEnterprise(index, updaeEnterpriseName, updaeEnterpriseName);
                    break;
                case 7:
                    enterprise.listAllEnterprises();
                    int deleteindex = Integer.parseInt(getInput("请输入要删除索引：", scanner));
                    enterprise.deleteEnterprise(deleteindex);
                case 8:
                    displayMenu();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("输入的功能无效");
            }
        }

    }

    public static String getInput(String prompt, Scanner scanner) {
        System.out.print(prompt);
        return scanner.next();
    }


    public static void displayMenu() {
        System.out.println("************ 欢迎进入企业管理系统 ************");
        System.out.println("按1. 查询所有企业");
        System.out.println("按2. 根据企业名中的关键字查询企业");
        System.out.println("按3. 根据关键字统计符合关键字的企业有多少家");
        System.out.println("按4. 根据企业成立的时间区查询企业");
        System.out.println("按5. 新增一家企业");
        System.out.println("按6. 根据下标修改一家企业");
        System.out.println("按7. 根据下标删除一家企业");
        System.out.println("按8. 帮助");
        System.out.println("按0. 退出");
        System.out.println("************************************");
    }
}
