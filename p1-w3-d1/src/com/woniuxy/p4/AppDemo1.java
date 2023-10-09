package com.woniuxy.p4;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AppDemo1 {
    public static void main(String[] args) {
        Map<Integer, Product> productMap = new TreeMap<>();
        // 添加10条记录到 TreeMap
        productMap.put(1, new Product(1, "手机", 2999.99, 100, "电子产品"));
        productMap.put(2, new Product(2, "电视", 4999.99, 50, "电子产品"));
        productMap.put(3, new Product(3, "衣服", 199.99, 200, "服装"));
        productMap.put(4, new Product(4, "鞋子", 399.99, 150, "服装"));
        productMap.put(5, new Product(5, "牛奶", 9.99, 500, "食品"));
        productMap.put(6, new Product(6, "面包", 5.99, 300, "食品"));
        productMap.put(7, new Product(7, "书籍", 59.99, 80, "图书"));
        productMap.put(8, new Product(8, "笔记本电脑", 5999.99, 30, "电子产品"));
        productMap.put(9, new Product(9, "水杯", 19.99, 100, "生活用品"));
        productMap.put(10, new Product(10, "洗发水", 29.99, 200, "生活用品"));

        //添加商品：向Map中添加商品
        //删除商品：输入商品的编号，将其从库存中删除。
        System.out.print("请输入要删除的索引:");
        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt();
        productMap.remove(index);
        productMap.forEach((key, value) -> System.out.println("key:" + key + "\n商品:" + value + "\n"));

        //更新商品价格：输入商品的编号，将对应商品的价格和库存更新。
        System.out.print("请输入要修改价格的索引:");
        index = scanner.nextInt();
        System.out.print("请输入要修改的价格:");
        double price = scanner.nextDouble();
        productMap.get(index).setPrice(price);
        System.out.print("请输入要修改的库存:");
        int stock = scanner.nextInt();
        productMap.get(index).setStock(stock);
        productMap.forEach((key, value) -> System.out.println("key:" + key + "\n商品:" + value + "\n"));

        //查询商品信息：输入商品的编号，输出对应商品的信息。
        System.out.print("请输入要查询商品的编号: ");
        index = scanner.nextInt();
        System.out.println(productMap.get(index));
        System.out.println();

        //判断某个编号的商品是否存在
        System.out.print("请输入要查询商品是否存在的编号: ");
        index = scanner.nextInt();
        if (productMap.containsKey(index)) {
            System.out.println("存在商品编号" + index);
        } else {
            System.out.println("不存在商品编号" + index);
        }
        //遍历输出所有的商品信息
//        productMap.forEach((key, value) -> System.out.println("key:" + key + "商品" + value));
        //输出所有服装的商品 ( 提示： map.values() 方法可以获取所有的值对象，返回Collection集合，从而使用Stream来操作)
        productMap.values().stream().filter(product -> product.getCategory().equals("服装")).forEach(System.out::println);
        System.out.println();
        //输出所有价格大于2000的商品
        productMap.values().stream().filter(product -> product.getPrice() > 2000).forEach(System.out::println);

    }

}
