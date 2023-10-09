package com.woniuxy.p6;

import java.util.Scanner;

public class CommodityApp {

    static Scanner scanner = new Scanner(System.in);
    static CommodityDao commodityDao = CommodityFactory.createObject("text");


    public static void main(String[] args) {

        int choice;
        do {
            menu();
            System.out.print("请输入选项：");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    findAll();
                    break;
                case 2:
                    findById();
                    break;
                case 3:
                    addCommodity();
                    break;
                case 4:
                    delCommodity();
                    break;
                case 5:
                    updateCommodity();
                    break;
                case 6:
                    findByType();
                    break;
                case 7:
                    groupCommodityByTypename();
                    break;
                case 8:
                    groupCommodityByType();
                    break;
                case 9:
                    sortCommoditiesByPrice();
                    break;
                case 0:
                    System.out.println("谢谢使用，再见！");
                    System.exit(0);
                    break;
                default:
                    System.out.println("无效选项，请重新输入！");
                    break;
            }
            System.out.println();
        } while (choice != 0);
        scanner.close();

    }

    private static void groupCommodityByType() {
        System.out.println("分组显示:");
        commodityDao.groupCommodityByType().forEach((type,commodity) -> System.out.println(type+":"+commodity) );
    }

    private static void sortCommoditiesByPrice() {
        System.out.print("请选择排序方式 (1升序，2降序): ");
        int sortOrder = scanner.nextInt();
        boolean ascending = sortOrder == 1;
        commodityDao.sortCommoditiesByPrice(ascending).forEach(System.out::println);
    }

    private static void groupCommodityByTypename() {
        System.out.println("类型统计信息:");
        commodityDao.groupCommodityByTypename().forEach((type, count) -> System.out.println(type + ":" + count + "种"));
    }

    private static void findByType() {
        System.out.print("请输入商品的类型: ");
        String type = scanner.next();
        commodityDao.findByType(type).forEach(System.out::println);
    }

    private static void updateCommodity() {
        System.out.print("请输入商品的ID: ");
        int id = scanner.nextInt();
        System.out.print("请输入商品的名称: ");
        String name = scanner.next();
        System.out.print("请输入商品的价格: ");
        int price = scanner.nextInt();
        System.out.print("请输入商品的类型: ");
        String type = scanner.next();
        Commodity commodity = commodityDao.createCommodity(id, name, price, type);
        commodityDao.updateCommodity(id, commodity);
        System.out.println("商品信息已更新！");

    }

    private static void delCommodity() {
        System.out.print("请输入要删除的商品的ID: ");
        int id = scanner.nextInt();
        commodityDao.delCommodity(id);
        System.out.println("商品已删除！");
    }

    private static void addCommodity() {
        System.out.print("请输入商品的名称: ");
        String name = scanner.next();
        System.out.print("请输入商品的价格: ");
        int price = scanner.nextInt();
        System.out.print("请输入商品的分类: ");
        String type = scanner.next();
        commodityDao.addCommodity(commodityDao.createCommodity(0, name, price, type));
        System.out.println("员工已添加！");
    }

    private static void findById() {
        System.out.print("请输入要查询的商品ID: ");
        int id = scanner.nextInt();
        Commodity commodity = commodityDao.findById(id);
        if (commodity != null) {
            System.out.println(commodity);
        } else {
            System.out.println("没有此ID的商品");
        }

    }

    private static void findAll() {
        commodityDao.findAll().forEach(System.out::println);
    }

    private static void menu() {
        System.out.println("---------- 商品管理系统 ----------");
        System.out.println("1. 获取所有的商品");
        System.out.println("2. 通过ID获取一件商品");
        System.out.println("3. 添加商品");
        System.out.println("4. 通过id删除商品");
        System.out.println("5. 通过id修改商品");
        System.out.println("6. 查询指定分类的商品");
        System.out.println("7. 按商品分类进行分组统计每种商品的数量");
        System.out.println("8. 按商品分类进行分组,显示每种商品的列表");
        System.out.println("9. 按价格对商品进行升序1或降序2的排序");
        System.out.println("0. 退出");
    }
}
