package com.woniuxy.p4;

import java.util.List;
import java.util.Scanner;

public class AppDemo1 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        FoodstuffDao foodstuffDao = new FoodstuffDao("F:\\workspace\\j07\\textfile.txt");
        menu();
        while (true) {
            System.out.print("请选择功能编号: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    // 查询所有食品信息的逻辑
                    System.out.println("执行查询所有食品信息的操作");
                    List<String> list = foodstuffDao.findAll();
                    System.out.println(list);
                    break;
                case 2:
                    // 根据关键字查询食品的逻辑
                    System.out.println("执行根据关键字查询食品的操作");
                    System.out.print("请输入要查询的关键字: ");
                    String keywords = scanner.next();
                    List<String> byKeywords = foodstuffDao.findByKeywords(keywords);
                    System.out.println(byKeywords);
                    break;
                case 3:
                    // 新增食品的逻辑
                    System.out.println("执行新增食品的操作");
                    System.out.print("请输入新增食物的名称: ");
                    String foodstuff = scanner.next();
                    foodstuffDao.addFoodstuff(foodstuff);
                    System.out.println("添加成功");
                    break;
                case 4:
                    // 删除食品的逻辑
                    System.out.println("执行删除食品的操作");
                    System.out.print("请输入要删除的食物的名称: ");
                    foodstuff = scanner.next();
                    foodstuffDao.delFoodstuff(foodstuff);
                    System.out.println("删除成功");
                    break;
                case 5:
                    System.out.println("执行修改食品的操作");
                    System.out.print("请输入要修改的食物的名称: ");
                    foodstuff = scanner.next();
                    System.out.print("请输入要修改后的食物的名称: ");
                    String lastFoodstuff =scanner.next();
                    foodstuffDao.updateFoodstuff(lastFoodstuff,foodstuff);
                    break;
                case 6:
                    menu();
                    break;
                case 0:
                    // 退出程序
                    System.out.println("程序已退出!");
                    System.exit(1);
                    break;
                default:
                    System.out.println("无效的选项，请重新输入!");
                    break;
            }
        }
    }

    public static void menu(){
        System.out.println("----------食品管理系统---------");
        System.out.println("按1.查询所有食品信息");
        System.out.println("按2.根据关键字查询食品");
        System.out.println("按3.新增食品");
        System.out.println("按4.删除食品");
        System.out.println("按5.修改食品");
        System.out.println("按6,帮助");
        System.out.println("按.退出");
    }
}