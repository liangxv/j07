package com.woniuxy.pi;

import java.util.Arrays;
import java.util.Scanner;

public class AppDemo4 {
    // 商品信息数组
    static String[] products = {
            "洗面奶-日用品-50",
            "鼠标-数码-80",
            "冰箱-家电-3500",
            "体恤-服装-100",
            "手机-数码-2000",
            "牛奶-食品-15",
            "电视-家电-5000",
            "笔记本电脑-数码-6000"
    };
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        displayMenu();
        while (true) {
            System.out.print("请输入功能编号： ");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    listAllProducts();
                    break;
                case 2:
                    addProduct();
                    break;
                case 3:
                    updateProduct();
                    break;
                case 4:
                    deleteProduct();
                    break;
                case 5:
                    findProductsByPriceRange();
                    break;
                case 6:
                    countProductsByCategory();
                    break;
                case 0:
                    System.exit(1);
                    break;
                case 7:
                    displayMenu();
                    break;
                default:
                    System.out.println("选择错误");
            }
        }
    }

    // 查询所有商品
    public static void listAllProducts() {
        System.out.println("************ 所有商品列表 ************");
        for (int i = 0; i < products.length; i++) {
            String product = products[i];
            String[] split = product.split("-");
            System.out.println("索引" + i + "\t\t商品: " + split[0] + "\t\t分类:" + split[1] + "\t\t价格: " + split[2]);
        }
        System.out.println("************************************");
    }

    // 新增商品
    public static void addProduct() {
        System.out.println("************ 新增商品 ************");
        System.out.print("请输入商品名称: ");
        String name = scanner.next();
        System.out.print("请输入商品分类: ");
        String category = scanner.next();
        int price = readInt("请输入商品价格: ");

        // 创建新商品数组并添加新商品
        String[] newProducts = Arrays.copyOf(products, products.length + 1);
        newProducts[newProducts.length - 1] = name + "-" + category + "-" + price;
        products = newProducts;

        System.out.println("新增商品成功！");
        System.out.println("************************************");
    }

    // 更新商品信息
    public static void updateProduct() {
        System.out.println("************ 修改商品 ************");
        listAllProducts();
        int index = readInt("请输入要修改商品的索引：");

        // 检查索引是否有效
        if (index >= 0 && index < products.length) {
            System.out.print("请输入商品名称: ");
            String name = scanner.next();
            System.out.print("请输入商品分类: ");
            String category = scanner.next();
            int price = readInt("请输入商品价格: ");

            // 更新商品信息
            products[index] = name + "-" + category + "-" + price;
            System.out.println("修改商品成功！");
        } else {
            System.out.println("索引无效，商品修改失败");
        }
        System.out.println("************************************");
    }

    // 删除商品
    public static void deleteProduct() {
        System.out.println("************ 删除商品 ************");
        listAllProducts();
        int index = readInt("请输入要删除商品的索引：");

        // 检查索引是否有效
        if (index >= 0 && index < products.length) {
            String temp = products[products.length - 1];
            products[products.length - 1] = products[index];
            products[index] = temp;
            String[] newProducts = Arrays.copyOf(products, products.length - 1);

            // 重新排序商品数组
            for (int i = index; i < newProducts.length - 1; i++) {
                newProducts[i] = newProducts[i + 1];
            }
            newProducts[newProducts.length - 1] = temp;
            products = newProducts;

            System.out.println("删除商品成功！");
        } else {
            System.out.println("索引无效，商品删除失败");
        }
        System.out.println("************************************");
    }

    // 按价格区间查询商品
    public static void findProductsByPriceRange() {
        System.out.println("************ 按价格区间查询商品 ************");
        int low = readInt("请输入最低价格: ");
        int high = readInt("请输入最高价格: ");
        System.out.println("************ 查询结果 ************");

        // 遍历商品数组，打印符合价格区间的商品信息
        for (String product : products) {
            String[] split = product.split("-");
            int price = Integer.parseInt(split[2]);
            if (low <= price && high >= price) {
                System.out.println("商品: " + split[0] + "\t\t分类:" + split[1] + "\t\t价格: " + split[2]);
            }
        }
        System.out.println("************************************");
    }

    // 按分类统计商品数量
    public static void countProductsByCategory() {
        System.out.println("************ 按分类统计商品数量 ************");
        System.out.print("请输入要显示的分类: ");
        String category = scanner.next();
        System.out.println("************ 统计结果 ************");
        int count = 0;

        // 遍历商品数组，统计符合指定分类的商品数量
        for (String product : products) {
            String[] split = product.split("-");
            if (split[1].equals(category)) {
                count++;
            }
        }

        System.out.println("分类 '" + category + "' 下共有 " + count + " 个商品");
        System.out.println("************************************");
    }

    // 读取整数输入
    public static int readInt(String message) {
        int value = 0;
        boolean validInput = false;
        while (!validInput) {
            System.out.print(message);
            if (scanner.hasNextInt()) {
                value = scanner.nextInt();
                validInput = true;
            } else {
                System.out.println("请输入有效的整数");
                scanner.next();
            }
        }
        return value;
    }

    // 显示菜单
    public static void displayMenu() {
        System.out.println("************ 商品管理系统 ************");
        System.out.println("按1. 查询所有商品");
        System.out.println("按2. 新增商品");
        System.out.println("按3. 修改商品");
        System.out.println("按4. 删除商品");
        System.out.println("按5. 按价格区间查询商品");
        System.out.println("按6. 按分类统计商品");
        System.out.println("按7. 帮助");
        System.out.println("按0. 退出");
        System.out.println("************************************");
    }
}
