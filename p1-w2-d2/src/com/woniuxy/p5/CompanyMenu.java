package com.woniuxy.p5;

import java.util.ArrayList;
import java.util.Scanner;

public class CompanyMenu {
    static CompanyDao companyDao = new CompanyDao();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        displayMenu();
        while (true) {
            System.out.print("请输入操作编号: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    findAll();
                    break;
                case 2:
                    keywordQueryCompany();
                    break;
                case 3:
                    timeRangeQueries();
                    break;
                case 4:
                    addCompany();
                    break;
                case 5:
                    deleteCompany();
                    break;
                case 6:
                    sortByYearAscending();
                    break;
                case 7:
                    displayMenu();
                    break;
                case 0:
                    System.out.println("谢谢使用，再见！");
                    System.exit(0);
                    break;
                default:
                    System.out.println("操作编号无效，请重新输入");
                    break;
            }
        }
    }

    private static void sortByYearAscending() {
        companyDao.sortByYearAscending();
        System.out.println("已排序");
    }

    private static void deleteCompany() {
        int index = Integer.parseInt(getInput("输入要删除的索引"));
        companyDao.deleteCompany(index);
        System.out.println("删除成功");
    }

    private static void addCompany() {
        String name = getInput("输入企业名称: ");
        int year = Integer.parseInt(getInput("输入企业成立时间: "));
        String boos = getInput("输入企业的CEO: ");
        Company company = new Company(name, year, boos);
        companyDao.addCompany(company);
        System.out.println("添加成功: ");
    }

    private static void timeRangeQueries() {
        int start = Integer.parseInt(getInput("输入开始时间: "));
        int end = Integer.parseInt(getInput("输入结束时间: "));
        ArrayList<Company> timeRangeQueries = companyDao.timeRangeQueries(start, end);
        printCompany(timeRangeQueries);
    }

    private static void keywordQueryCompany() {
        String s = getInput("输入关键字: ");
        ArrayList<Company> companies = companyDao.keywordQueryCompany(s);
        printCompany(companies);
    }

    private static void findAll() {
        ArrayList<Company> all = companyDao.findAll();
        printCompany(all);
    }

    private static void printCompany(ArrayList<Company> companies) {
        for (Company company : companies) {
            System.out.println(company);
        }
    }

    private static String getInput(String str) {
        System.out.print(str);
        return scanner.next();
    }

    public static void displayMenu() {
        System.out.println("========== 企业管理系统 ==========");
        System.out.println("1. 查询所有企业资源");
        System.out.println("2. 根据关键字查询企业资源");
        System.out.println("3. 根据企业的成立时间范围查询企业资源");
        System.out.println("4. 新增一家企业");
        System.out.println("5. 删除一家企业");
        System.out.println("6. 按企业成立的时间进行升序排序");
        System.out.println("7. 帮助");
        System.out.println("0. 退出系统");
        System.out.println("=================================");
    }

}
